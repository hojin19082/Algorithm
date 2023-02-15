package Level2;
import java.util.*;
public class 무인도여행 {

	
	    boolean[][] visited;
	    int[][] map;
	    int[] dx = {-1, 1, 0, 0};
	    int[] dy = {0,0,-1,1};
	    int cols;
	    int count;
	    public int[] solution(String[] maps) {
	        cols = maps[0].length();
	        map = new int[maps.length][cols];
	        visited = new boolean[maps.length][cols];
	        ArrayList<Integer> arr = new ArrayList<>();
	        for(int i=0; i<maps.length; i++){
	            for(int j=0; j<cols; j++){
	                if(maps[i].charAt(j) == 'X'){
	                    map[i][j] = 0;
	                }else{
	                    map[i][j] = maps[i].charAt(j) - '0';
	                }
	                visited[i][j] = false;
	            }
	        }
	        for(int i=0; i<maps.length; i++){
	            for(int j=0; j<cols; j++){
	                if(!visited[i][j] && map[i][j] != 0){
	                    count=0;
	                    dfs(i, j, count);
	                    if(count!=0){
	                        arr.add(count);
	                    }
	                }
	            }
	        }
	        if(arr.size() == 0){
	            int[] answer = new int[1];
	            answer[0] = -1;
	            return answer;
	        }
	        Collections.sort(arr);
	        int[] answer = new int[arr.size()];
	        for(int i=0; i<arr.size(); i++){
	            answer[i] = arr.get(i);
	        }
	        return answer;
	    }
	    public void dfs(int x, int y, int k){
	        visited[x][y] = true;
	        count = k + map[x][y];
	        for(int i=0; i<4; i++){
	            int cx = dx[i] + x;
	            int cy = dy[i] + y;
	            if(cx>=0 && cy>=0 && cx<map.length && cy<cols){
	                if(!visited[cx][cy] && map[cx][cy] != 0){
	                    dfs(cx, cy, count);
	                }
	            }
	        }
	        
	    }

}
