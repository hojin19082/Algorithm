package Level2;
import java.util.*;
public class 미로탈출 {

	    static class Node{
	        int x, y, length;
	        Node(int x, int y, int length){
	            this.x = x;
	            this.y = y;
	            this.length = length;
	        }
	    }
	    static int[] dx = {-1,1,0,0};
	    static int[] dy = {0,0,-1,1};
	    static char[][] map;
	    static int rever_x = 0;
	    static int rever_y = 0;
	    static int answer = 0;
	    static boolean flag = false;
	    public int solution(String[] maps) {    
	        int start_x = 0;
	        int start_y = 0;
	        
	        map = new char[maps.length][maps[0].length()];
	        for(int i=0; i<maps.length; i++){
	            for(int j=0; j<maps[i].length(); j++){
	                map[i][j] = maps[i].charAt(j);
	                if(map[i][j] == 'S'){
	                    start_x = i;
	                    start_y = j;
	                }else if(map[i][j] == 'L'){
	                    rever_x = i;
	                    rever_y = j;
	                }
	            }
	        }
	        //레버까지 최단경로
	        bfs(start_x, start_y);
	        if(answer != -1){
	            bfs(rever_x, rever_y);
	        }
	        //레버부터 출구까지 최단경로;
	        return answer;
	    }
	    public static void bfs(int x, int y){
	        Queue<Node> q = new LinkedList<>();
	        q.offer(new Node(x, y, 0));
	        boolean[][] visited = new boolean[map.length][map[0].length];
	        visited[x][y] = true;
	        while(!q.isEmpty()){
	            Node n = q.poll();
	            
	            for(int i=0; i<4; i++){
	                int nx = n.x + dx[i];
	                int ny = n.y + dy[i];
	                if(nx<0 || ny<0 || nx>=map.length 
	                   || ny>=map[0].length || visited[nx][ny]
	                   || map[nx][ny] == 'X') continue;
	                visited[nx][ny] = true;
	                //레버이면
	                if(map[nx][ny] == 'L' && !flag){
	                    answer += n.length+1;
	                    flag = true;
	                    return;
	                }
	                //출구이면
	                if(map[nx][ny] == 'E' && flag){
	                    answer += n.length+1;
	                    return;
	                }
	                q.offer(new Node(nx, ny, n.length+1));
	            }
	        }
	        answer = -1;
	        return;
	    }
	}


