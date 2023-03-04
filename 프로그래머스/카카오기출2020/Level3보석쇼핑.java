package 카카오기출2020;
import java.util.*;
public class Level3보석쇼핑 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};

        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(gems)));
	} 
	static class Solution{
	public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Stack<String> stack = new Stack<>();
        for(int i=0; i<gems.length; i++){
            if(!stack.contains(gems[i])){
                stack.push(gems[i]);
            }
        }
        
        int distance = Integer.MAX_VALUE;
        //범위
        int left = 0;
        int right = 0;

        //정답
        int start = 0;
        int end = 0;
        
        Map<String, Integer> map = new HashMap<>();  
        while(true){
        	if(map.size() == stack.size()) {
        		map.put(gems[left], map.get(gems[left])-1);
        		
        		if(map.get(gems[left]) == 0) {
        			map.remove(gems[left]);
        		}
        		left++;
        	}else if(right == gems.length) {
        		break;
        	}else {
        		map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
        		right++;
        	}
        	
        	if(map.size() == stack.size()) {
        		if(right-left < distance) {
        			distance = right - left;
        			start = left+1;
        			end = right;
        		}
        	}
        	
        }
        answer[0] = start;
        answer[1] = end;
       
        return answer;
    }
}

}
