package Level2;
import java.util.*;
public class ������ũ�ڸ��� {
	class Solution {
	    public int solution(int[] topping) {
	        int answer = 0;
	        HashMap<Integer, Integer> map = new HashMap<>();
	        for(int i=0; i<topping.length; i++){
	            map.put(topping[i], map.getOrDefault(topping[i], 0)+1);
	        }
	        
	        HashSet<Integer> set = new HashSet<>();
	        for(int i=0; i<topping.length; i++){
	            set.add(topping[i]);
	            map.put(topping[i], map.get(topping[i])-1);
	            if(map.get(topping[i]) == 0) map.remove(topping[i]);
	            if(set.size() == map.size()) {
	                answer++;
	            }
	            
	        }
	        
	        return answer;
	    }

	}

}
