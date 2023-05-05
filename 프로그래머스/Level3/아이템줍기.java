package Level3;
import java.util.*;
public class 아이템줍기 {
	    static char map[][]=new char[101][101];
	    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
	        for(int i=0; i<rectangle.length; i++){
	            int y1=rectangle[i][1];
	            int x1=rectangle[i][0];
	            int y2=rectangle[i][3];
	            int x2=rectangle[i][2];
	            draw(y1*2,x1*2,y2*2,x2*2);
	        }
	        return bfs(characterY*2,characterX*2,itemY*2,itemX*2);
	    }
	    public static int bfs(int y, int x, int findY, int findX){
	        int dy[] = {-1,1,0,0};
	        int dx[] = {0,0,-1,1};
	        Queue<Integer[]> q = new LinkedList<>();
	        q.offer(new Integer[]{y,x,0});
	        boolean visited[][] = new boolean[101][101];
	        while(!q.isEmpty()){
	            Integer temp[] = q.poll();
	            int prevY = temp[0];
	            int prevX = temp[1];
	            int count = temp[2];
	            if(prevY == findY && prevX == findX) return count/2;
	            for(int i=0; i<4; i++){
	                int nx = prevX + dx[i];
	                int ny = prevY + dy[i];
	                if(nx < 0 || ny<0 || nx>=map[0].length||ny>=map.length)
	                    continue;
	                if(visited[ny][nx] || map[ny][nx] != '2')
	                    continue;
	                visited[ny][nx]  = true;
	                q.add(new Integer[]{ny,nx,count+1});
	            }
	        }
	        return 0;
	    }
	    
	    public static void draw(int y1, int x1, int y2, int x2){
	        for(int i=y1; i<=y2; i++){
	            for(int j=x1; j<=x2; j++){
	                if(map[i][j]=='1') continue;
	                map[i][j] = '1';
	                if(i==y1 || i==y2 || j==x1 || j==x2){
	                    map[i][j] = '2';
	                }
	            }
	        }
	    }
}
