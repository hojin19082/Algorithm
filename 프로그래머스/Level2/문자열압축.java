package Level2;
import java.util.*;
public class 문자열압축 {

	class Solution {
	    public int solution(String s) {
	        int answer = Integer.MAX_VALUE;
	        if(s.length()==1) answer = 1;
	        else{
	            for(int i=1; i<=s.length()/2; i++){
	                int result = capsulation(s, i);
	                answer = Math.min(answer, result);
	             }
	        }
	        return answer;
	    }
	    public int capsulation(String s, int index){
	        Map<String, Integer> map = new HashMap<>();
	        String pre = s.substring(0, index);
	        map.put(pre, 1);
	        int i=index;
	        String answer = "";
	        while(true){
	            if(i+index > s.length()) {
	                if(map.get(pre) == 1) answer+=pre;
	                else if(map.get(pre) >1) answer += Integer.toString(map.get(pre)) + pre;
	                break;
	            }
	            String str = s.substring(i, i+index);
	            if(str.equals(pre)){
	                map.put(str, map.get(str)+1);
	            }else{
	                if(map.get(pre) == 1) answer+=pre;
	                else answer += Integer.toString(map.get(pre)) + pre;
	                map.put(str, 1);
	            }
	            pre = str;
	            i+=index;
	        }
	        if(i != s.length()) answer += s.substring(i);
	        return answer.length();
	    }
	}

}
