package Level2;

import java.util.*;
public class 전력망을둘로나누기 {
	    static int N;
	    public int solution(int n, int[][] wires) {
	        int answer = n+1;
	        N = n;
	        int[][] map = new int[n+1][n+1];
	        for(int i=0; i<wires.length; i++){
	            map[wires[i][0]][wires[i][1]] = 1;
	            map[wires[i][1]][wires[i][0]] = 1;
	        }
	        
	        for(int i=0; i<wires.length; i++){
	            int[][] temp = new int[n+1][n+1];
	            for(int j=0; j<n+1; j++){
	                temp[j] = Arrays.copyOf(map[j], n+1);
	            }
	            int v1 = wires[i][0];
	            int v2 = wires[i][1];
	            temp[v1][v2] = 0;
	            temp[v2][v1] = 0;
	            
	            int count1 = bfs(v1, temp);
	            int count2 = bfs(v2, temp);
	            answer = Math.min(answer, Math.abs(count1 - count2));
	        }
	        return answer;
	    }
	    public static int bfs(int v, int[][] temp){
	        boolean[] visited = new boolean[N+1];
	        Queue<Integer> q = new LinkedList<>();
	        q.offer(v);
	        int count = 1;
	        visited[v] = true;
	        while(!q.isEmpty()){
	            int num = q.poll();
	            for(int i=1; i<=N; i++){
	                if(!visited[i] && temp[num][i] == 1) {
	                    visited[i] = true;
	                    count++;
	                    temp[num][i] = 0;
	                    q.offer(i);
	                }
	            }
	        }
	       return count;
	    
	    }

}
