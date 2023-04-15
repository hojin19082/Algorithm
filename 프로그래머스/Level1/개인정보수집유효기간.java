package Level1;
import java.util.*;
public class 개인정보수집유효기간 {

	
	class Solution {
	    public int[] solution(String today, String[] terms, String[] privacies) {
	        Map<Character, Integer> map = new HashMap<>();
	        for(int i=0; i<terms.length; i++){
	            map.put(terms[i].charAt(0), Integer.parseInt(terms[i].substring(2)));
	        }
	        int[] arr = new int[101];
	        int count = 0;
	        for(int i=0; i<privacies.length; i++){
	            String year = privacies[i].substring(0,4);
	            String month = privacies[i].substring(5,7);
	            if(month.charAt(0) == '0'){
	                month = month.substring(1);
	            }
	            String day = privacies[i].substring(8, 10);
	            if(day.charAt(0) == '0'){
	                day = day.substring(1);
	            }
	            char period = privacies[i].charAt(11);
	            
	            int plus_month = map.get(period);
	            //달을 더해주고
	            
	            if(Integer.parseInt(month) + plus_month > 12){
	                int temp = (Integer.parseInt(month) + plus_month)%12;
	                int y_temp = (Integer.parseInt(month) + plus_month)/12;
	                
	                if(temp == 0){
	                    month ="12";
	                    year = String.valueOf(Integer.parseInt(year) + y_temp-1);
	                }else{
	                    month = String.valueOf(temp);
	                    year = String.valueOf(Integer.parseInt(year) + y_temp);
	                }
	                
	                
	            }else {
	                month = String.valueOf(Integer.parseInt(month) + plus_month);
	            }
	            
	            if(Integer.parseInt(day) == 1){
	                day = "28";
	                if(Integer.parseInt(month) -1 == 0){
	                    month = "12";
	                    year = String.valueOf(Integer.parseInt(year)-1);
	                    
	                }else{
	                    month = String.valueOf(Integer.parseInt(month)-1);
	                }
	            }else{
	                day = String.valueOf(Integer.parseInt(day)-1);
	            }
	            
	            if(Integer.parseInt(today.substring(0,4)) < Integer.parseInt(year)){
	                continue;
	            }else if(Integer.parseInt(today.substring(0,4)) == Integer.parseInt(year)){
	                if(Integer.parseInt(today.substring(5,7)) < Integer.parseInt(month)){
	                    continue;
	                }else if (Integer.parseInt(today.substring(5,7)) == Integer.parseInt(month)){
	                    if(Integer.parseInt(today.substring(8)) <= Integer.parseInt(day)){
	                        continue;
	                    }else{
	                        arr[count] = i+1;
	                    }
	                }else{
	                    arr[count] = i+1;
	                }
	            }else{
	                arr[count] = i+1;
	            }
	            count++;
	        }
	        
	        int[] answer = new int[count];
	        for(int i=0; i<count; i++){
	            answer[i] = arr[i];
	        }
	        return answer;
	    }
	}

}
