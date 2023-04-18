package Level1;
import java.util.*;
public class ½ÇÆÐÀ² {


	class Solution {
	    public int[] solution(int N, int[] stages) {
	        int[] answer = new int[N+1];
	        for(int i=0; i<stages.length; i++){
	            if(stages[i] > N) {
	                continue;
	            }else{
	                answer[stages[i]]++;
	            }
	        }
	        int sum = 0;
	        Map<Double, List<Integer>> map = new HashMap<>();
	        double[] arr = new double[N+1];
	         for(int i=1; i<=N; i++){
	            int num = answer[i];
	             if(num == 0) arr[i] = 0.0;
	             else{
	                 arr[i] = (double)num/ (double) (stages.length - sum);
	             }
	            if(!map.containsKey(arr[i])){
	                map.put(arr[i], new ArrayList<>());
	            }
	            map.get(arr[i]).add(i);
	            sum += num;
	        }
	        Arrays.sort(arr);
	        
	        int[] rank = new int[N];
	        int count = 0;
	        for(int i=N; i>=1; i--){
	            if(i<N && arr[i] == arr[i+1]) continue;
	            for(int j=0; j<map.get(arr[i]).size(); j++){
	                rank[count] = map.get(arr[i]).get(j);
	                count++;
	            }
	            
	        }
	        return rank;
	    }
	}

}
