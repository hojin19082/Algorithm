package Level2;
import java.util.*;
public class 주식가격 {

	class Solution {
	    public int[] solution(int[] prices) {
	        int[] answer = new int[prices.length];
	        Stack<Integer> stack = new Stack<>();
	        ArrayList<Integer> list = new ArrayList<>();
	        
	        for(int i=0; i<prices.length; i++){
	            if(list.size() > 0){
	                for(int k=0; k<list.size(); k++){
	                    answer[list.get(k)]++;
	                }
	            }
	            
	            if(!stack.isEmpty()){
	                int j = list.size()-1;
	                while(stack.size()>0 && stack.peek() > prices[i]){
	                    stack.pop();
	                    list.remove(j);
	                    j--;
	                }
	            }
	            stack.push(prices[i]);
	            list.add(i);
	        }
	        
	        return answer;
	    }
	}
}
