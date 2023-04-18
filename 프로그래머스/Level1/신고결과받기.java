package Level1;
import java.util.*;
public class �Ű����ޱ� {


	class Solution {
	    public int[] solution(String[] id_list, String[] report, int k) {
	        int[] answer = new int[id_list.length];
	        //�Ű� ���� ���, Ƚ��
	        Map<String, Integer> map1 = new HashMap<>();
	        //�Ű� ���� ���, �Ű��� ��� list
	        Map<String, List<String>> map2 = new HashMap<>();
	        
	        for(int i=0; i<id_list.length; i++){
	            map2.put(id_list[i], new ArrayList<>());
	        }
	        
	        for(int i=0; i<report.length; i++){
	            String[] str = report[i].split(" ");
	            if(map2.get(str[1]).contains(str[0])) continue;
	            
	            map2.get(str[1]).add(str[0]);
	            
	            //�Ű���� Ƚ��
	            map1.put(str[1], map1.getOrDefault(str[1],0)+1);
	        }
	        
	        for(String key : map1.keySet()){
	            if(map1.get(key)>=k){
	                for(String key1 : map2.get(key)){
	                    answer[Arrays.asList(id_list).indexOf(key1)]++;
	                }
	            }
	        }

	        return answer;
	    }
	}
}
