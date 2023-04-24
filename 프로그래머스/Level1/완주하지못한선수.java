package Level1;
import java.util.*;
public class 완주하지못한선수 {


	class Solution {
	    public String solution(String[] participant, String[] completion) {
	        String answer = "";
	        Map<String, Integer> map = new HashMap<>();
	        for(int i=0; i<completion.length; i++){
	            map.put(completion[i], map.getOrDefault(completion[i], 0)+1);
	        }
	        for(int i=0; i<participant.length; i++){
	            if(map.containsKey(participant[i])){
	                if(map.get(participant[i])>0)
	                map.put(participant[i], map.get(participant[i])-1);
	                else answer = participant[i];
	            }else{
	                answer = participant[i];
	            }
	        }
	        
	        return answer;
	    }
	}

}
