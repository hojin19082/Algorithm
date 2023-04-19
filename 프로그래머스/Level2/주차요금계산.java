package Level2;
import java.util.*;
public class 주차요금계산 {


	class Solution {
	    public int[] solution(int[] fees, String[] records) {

	        Map<String, String> map = new HashMap<>();
	        Map<String, Integer> map2 = new HashMap<>();
	        
	        for(int i=0; i<records.length; i++){
	            String[] arr = records[i].split(" ");
	            if(arr[2].equals("IN")){
	                map.put(arr[1], arr[0]);
	            }else{
	                //Out일 경우
	                String time = map.get(arr[1]);
	                map.remove(arr[1]);
	                String[] inTime = time.split(":");
	                String[] outTime = arr[0].split(":");
	                int t = Integer.parseInt(outTime[0]) - Integer.parseInt(inTime[0]);
	                int m = Integer.parseInt(outTime[1]) - Integer.parseInt(inTime[1]);
	                if(m<0){
	                    t--;
	                    m += 60;
	                }
	                int value = 60 * t + m;
	                map2.put(arr[1], map2.getOrDefault(arr[1], 0) + value);
	            }
	        }
	        for(String key : map.keySet()){
	            String time = map.get(key);
	            String[] inTime = time.split(":");
	            int t = 23 - Integer.parseInt(inTime[0]);
	            int m = 59 - Integer.parseInt(inTime[1]);
	            if(m<0){
	                t--;
	                m += 60;
	            }
	            int value = t * 60 + m;
	            map2.put(key, map2.getOrDefault(key,0) + value);
	        }
	        
	        int[] answer = new int[map2.size()];
	        int i=0;
	        List<String> keySet = new ArrayList<>(map2.keySet());

	        // 키 값으로 오름차순 정렬
	        Collections.sort(keySet);
	        
	        for(String key : keySet){
	            int time = map2.get(key);
	            if(time <= fees[0]){
	                answer[i] = fees[1];
	            }else{
	                if((time-fees[0]) % fees[2] == 0){
	                    answer[i] = fees[1] + ((time-fees[0]) / fees[2]) * fees[3];
	                }else{
	                    answer[i] = fees[1] + (((time-fees[0]) / fees[2])+1) * fees[3];
	                }
	                
	            }
	            i++;
	        }
	        return answer;
	    }
	}

}
