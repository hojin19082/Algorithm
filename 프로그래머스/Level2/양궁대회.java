package Level2;
public class 양궁대회 {
	class Solution {
	    int max = 0;
	    int[] answer;
	    int[] apeach_arr = new int[11];
	    public int[] solution(int n, int[] info) {
	        int[] arr = new int[11];
	        answer = new int[11];
	        apeach_arr = info;
	        dfs(0, n, arr,0);
	        System.out.println(max);
	        if(max == 0){
	            answer = new int[1];
	            answer[0] = -1;
	        }
	        return answer;
	    }
	    
	    public void dfs(int count, int n, int[] arr, int start){
	        if(count == n){
	            //점수비교
	            int apeach = 0;
	            int lion = 0;
	            for(int i=0; i<11; i++){
	                
	                if(apeach_arr[i] < arr[i]){
	                    lion += 10-i;
	                }else {
	                    if(apeach_arr[i] !=0){
	                        apeach += 10-i;
	                    }
	                }
	            }
	            if(max < lion - apeach){
	                max = lion - apeach;
	                answer = arr.clone();         
	            }else if(max == lion - apeach){
	                for(int i=10; i>=0; i--){
	                    if(answer[i] == arr[i]) continue;
	                    if(answer[i] < arr[i]) answer = arr.clone();
	                    break;
	                }   
	            }
	            
	            return;
	        }
	        for(int i=start; i<11; i++){
	            arr[i]++;
	            dfs(count+1, n, arr, i);
	            arr[i]--;
	        }
	    }
	}

}
