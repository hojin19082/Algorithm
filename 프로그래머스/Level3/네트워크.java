package Level3;
import java.util.*;
public class 네트워크 {

	    static ArrayList<Integer>[] arr;
	    static boolean[] visited;
	    public int solution(int n, int[][] computers) {
	        int answer = 0;
	        arr = new ArrayList[n];
	        visited= new boolean[n];
	        for(int i=0; i<n; i++){
	            arr[i] = new ArrayList<>();
	        }
	        
	        for(int i=0; i<computers.length; i++){
	            for(int j=0; j<computers[i].length; j++){
	                if(i!=j && computers[i][j] == 1){
	                    arr[i].add(j);
	                }
	            }
	        }
	        
	        for(int i=0; i<n; i++){
	            if(!visited[i]){
	                bfs(i);
	                answer++;
	            }
	        }
	        
	        return answer;
	    }
	    public static void bfs(int start){
	        visited[start] = true;
	        Queue<Integer> q = new LinkedList<>();
	        q.add(start);
	        while(!q.isEmpty()){
	            int num = q.poll();
	            for(int i : arr[num]){
	                if(!visited[i]){
	                    visited[i] = true;
	                    q.offer(i);
	                }
	            }
	        }
	    }
	
}
