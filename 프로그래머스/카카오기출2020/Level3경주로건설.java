package 카카오기출2020;
import java.util.*;
public class Level3경주로건설 {
	static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][][] visited;
    private static int[][] map;
    static int N;
    static int cost = Integer.MAX_VALUE;
    public int solution(int[][] board) {
        int answer = 0;
        N = board.length;
        visited = new boolean[N][N][4];
        visited[0][0][0] = true;
        visited[0][0][1] = true;
        visited[0][0][2] = true;
        visited[0][0][3] = true;
        map = board;
        bfs(0,0,-1,0);

        answer = cost;
        return answer;
    }
    public static void bfs(int x, int y, int dir, int price){
        Queue<Road> queue = new LinkedList<>();
        queue.add(new Road(x,y,dir,price));
        
        while(!queue.isEmpty()){
            Road r = queue.poll();
            
            if(r.x == N-1 && r.y == N-1) {
                cost = Math.min(cost, r.price);
            }
                
            for(int i=0; i<4; i++){
                int cx = r.x + dx[i];
                int cy = r.y + dy[i];
                int ndir = i;
                int nprice = r.price;
                
                if(cx <0 || cy <0 || cx>=N || cy>=N || map[cx][cy] == 1) {continue;}
                    
                    if(r.dir == -1){
                        nprice += 100;
                    }else if(r.dir == ndir){
                        nprice += 100;
                    }else{
                        nprice += 600;
                    }
                    
                    if(!visited[cx][cy][i] || map[cx][cy] >= nprice){
                        visited[cx][cy][i] = true;
                        map[cx][cy] = nprice;
                        queue.add(new Road(cx,cy, ndir, nprice));
                    }
                }
            }
            
        }
    
       
    }
class Road {
    int x;
    int y;
    int dir;
    int price;
    Road(int x, int y, int dir, int price){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.price = price;
    }
}
