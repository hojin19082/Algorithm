package 카카오기출2021;
import java.util.*;
class 거리두기확인 {
    static char[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean flag;
    static boolean[][] visited;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i=0; i<5; i++){
            map = new char[5][5];
            visited = new boolean[5][5];
            flag = false;
            for(int j=0; j<5; j++){
                for(int k=0; k<5; k++){
                    map[j][k] = places[i][j].charAt(k);
                }
            }
            
            for(int j=0; j<5; j++){
                for(int k=0; k<5; k++){
                    if(map[j][k] == 'P'){
                        if(visited[j][k]){
                            flag = true;
                            break;
                        }
                        bfs(j,k);
                    }
                }
                if(flag == true) break;
            }
            
            if(flag == true){
                answer[i] = 0;
                
            }else{
                answer[i] = 1;
            }
        }
         return answer;
    }
    
    public static void bfs(int x, int y){
        visited[x][y] = true;
        Queue<User> q = new LinkedList<>();
        q.offer(new User(x,y,0));
        
        while(!q.isEmpty()){
            User u = q.poll();
            for(int i=0; i<4; i++){
                int cx = u.x + dx[i];
                int cy = u.y + dy[i];
                int clength = u.length;
                if(cx >= 0 && cy >= 0 && cx <= 4 && cy <= 4 && u.length <2 && !visited[cx][cy]){
                    clength++;
                    
                    if(map[cx][cy] == 'O'){
                        visited[cx][cy] = true;
                        q.offer(new User(cx, cy, clength));
                        
                    }else if(map[cx][cy] == 'P'){
                        flag = true;
                        break;
                    }
                }
            }
        } 
    }
}
class User{
    int x;
    int y;
    int length;
    
    User(int x, int y, int length){
        this.x = x;
        this.y = y;
        this.length = length;
    }
}