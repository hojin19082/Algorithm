package Level2;

public class ÇÇ·Îµµ {

	class Solution {
	    boolean visited[];
	    int[] ans;
	    int answer = 0;
	    public int solution(int k, int[][] dungeons) {
	    
	        visited = new boolean[dungeons.length];
	        ans = new int[dungeons.length];
	        for(int i=0; i<ans.length; i++){
	            ans[i] = -1;
	        }
	        dfs(0, k, dungeons);
	            
	        return answer;
	    }
	    public void dfs(int count, int k, int[][] dungeons){
	        if(count == dungeons.length){
	            int cnt = 0;
	            for(int i=0; i<ans.length; i++){
	                if(ans[i] >= 0){
	                    cnt++;
	                }
	            }
	            answer = Math.max(answer, cnt);
	            return;
	        }
	        int temp = k;
	        for(int i=0; i<dungeons.length; i++){
	            if(!visited[i]){
	                visited[i] = true;
	                if(dungeons[i][0] <= k){
	                    ans[count] = k-dungeons[i][1];
	                    dfs(count+1, k-dungeons[i][1], dungeons);
	                    ans[count] = -1;
	                }else{
	                    dfs(count+1, temp, dungeons);
	                }
	                visited[i] = false;
	            }
	        }
	        
	    }
	}

}
