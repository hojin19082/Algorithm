import java.util.*;
class Solution {
    public static class Point{
        int count;
        int x,y;
        Point(int count, int x, int y){
            this.count = count;
            this.x = x;
            this.y = y;
        }
    }
    static char[][] map;
    static int N,M;
    static int Rx, Ry, Gx, Gy;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        map = new char[N][M];
        for(int i=0; i<N; i++){
            char[] charArr = board[i].toCharArray();
            for(int j=0; j<M; j++){
                map[i][j] = charArr[j];
                if(charArr[j] == 'R') {
                    Rx = i;
                    Ry = j;
                }else if(charArr[j]=='G'){
                    Gx = i;
                    Gy = j;
                }
            }
        }
        int answer = ricochat();
        return answer;
    }public static int ricochat(){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point( 0, Rx, Ry));
        boolean[][] visited = new boolean[N][M];
        visited[Rx][Ry] = true;
        while(!q.isEmpty()){
            Point now = q.poll();
            visited[now.x][now.y] = true;
            for(int i=0; i<4; i++){
                int nx = now.x;
                int ny = now.y;
                while(true){
                    if(nx+dx[i]<0 || ny+dy[i]<0 || nx+dx[i]>=N || ny+dy[i]>=M || map[nx+dx[i]][ny+dy[i]] == 'D') break;
                    nx += dx[i];
                    ny += dy[i];
                }
                if(nx == Gx && ny == Gy) {
                    return now.count+1;
                }
                if(!visited[nx][ny]){
                    q.offer(new Point(now.count+1,nx, ny));   
                }
            }
        }
        return -1;
    }
}
