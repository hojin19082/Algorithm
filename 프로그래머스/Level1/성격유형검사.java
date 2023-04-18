package Level1;
import java.util.*;
public class 성격유형검사 {


	class Solution {
	    public String solution(String[] survey, int[] choices) {
	        String answer = "";
	        Map<Character, Integer> map = new HashMap<>();
	        map.put('R', 0);
	        map.put('T', 0);
	        map.put('C', 0);
	        map.put('F', 0);
	        map.put('J', 0);
	        map.put('M', 0);
	        map.put('A', 0);
	        map.put('N', 0);
	        for(int i=0; i<survey.length; i++){
	            char ch1 = survey[i].charAt(0);
	            char ch2 = survey[i].charAt(1);
	            
	            if(choices[i]==4) continue;
	            if(choices[i]>=1 && choices[i]<=3){
	                //만약 1~3번을 선택했다면 앞 성격이 비동의 쪽
	                
	                map.put(ch1, map.get(ch1) + (4-choices[i]));
	            }else if(choices[i]>=5 && choices[i]<=7){
	                //만약 5~7번을 선택했다면 뒷 성격 동의 쪽
	                map.put(ch2, map.get(ch2) + (choices[i]-4));
	            }
	        }
	        
	        if(map.get('R') >= map.get('T')){
	            answer+="R";
	        }else {
	            answer+="T";
	        }
	        
	        if(map.get('C') >= map.get('F')){
	            answer+="C";
	        }else{
	             answer+="F";
	        }
	        
	        if(map.get('J') >= map.get('M')){
	            answer+="J";
	        }else{
	            answer+="M";
	        }
	        
	        if(map.get('A') >= map.get('N')){
	            answer+="A";
	        }else{
	            answer+="N";
	        }
	        
	        return answer;
	    }
	}

}
