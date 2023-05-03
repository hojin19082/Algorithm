package Level2;
import java.util.*;
public class 연속된부분수열의합 {
	//누적합 + 투포인터
	    static ArrayList<ArrayList<Integer>> list;
	    static int K;
	    public int[] solution(int[] sequence, int k) {
	        K=k;
	        list = new ArrayList<>();
	        int[] sum = new int[sequence.length+1];
	        sum[0] = sequence[0];
	        for(int i=0; i<sequence.length; i++){
	            sum[i+1] += sum[i] + sequence[i];
	        }
	        
	        int left = 0;
	        int right = 0;
	        int length = Integer.MAX_VALUE;
	        int[] answer = new int[2];
	        while(left <= right){
	            if(right == sum.length){
	                break;
	            }
	            int dif = sum[right] - sum[left];
	            if(dif==k){
	                if(length > right-left){
	                    length = right-left;
	                    answer[0] = left;
	                    answer[1] = right-1;
	                }
	                right++;
	            }else if(dif > k){
	                left++;
	            }else{
	                right++;
	            }
	        }
//	         for(int i=1; i<=sequence.length; i++){
//	             ArrayList<Integer> arr = new ArrayList<>();
//	             boolean[] visited = new boolean[sequence.length];
//	             dfs(0, 0, i, sequence, arr, visited);
//	         }

	        
//	         Collections.sort(list, (o1, o2) -> o1.size() - o2.size());
	       
//	         answer[0] = list.get(0).get(0) ;
//	         answer[1] = list.get(0).get(list.get(0).size()-1) ;
	        return answer;
	    }
//	    public static void dfs(int count, int start, int size, int[] sequence, ArrayList<Integer> arr, boolean[] visited){
//	        if(count == size){
//	            int sum = 0;
//	            for(int num : arr){
//	                sum += sequence[num];
//	            }
//	            if(sum == K){     
//	                list.add(new ArrayList<>(arr));
//	            }
//	            
//	            return;
//	        }
//	        for(int i=start; i<sequence.length; i++){
//	            if(!visited[i]){
//	                visited[i] =true;
//	                arr.add(i);
//	                dfs(count+1, i+1, size, sequence, arr, visited);
//	                arr.remove(0);
//	            }
//	        }
//	    }
	}

