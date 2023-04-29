package Level2;
import java.util.*;
public class ¿Ã¹Ù¸¥°ýÈ£ {


	class Solution {
	    boolean solution(String s) {
	        boolean answer = true;
	        Stack<Character> stack = new Stack<>();
	        for(int i=0; i<s.length(); i++){
	            if(s.charAt(i) == '('){
	                stack.push('(');
	            }else{
	                if(stack.isEmpty()) {
	                    answer = false;
	                    break;
	                }
	                
	                if(stack.peek() == '('){
	                    stack.pop();
	                }
	            }
	        }
	        if(stack.size() > 0) answer = false;

	        return answer;
	    }
	}

}
