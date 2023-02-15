package Level1;
import java.util.*;
public class 명예의_전당 {

	 public int[] solution(int k, int[] score) {
	        int[] answer = new int[score.length];
	        ArrayList<Integer> arr = new ArrayList<>();
	        for(int i=0; i<score.length; i++){
	            if(i>=k){
	                if(arr.get(0) < score[i]){
	                    arr.remove(0);
	                }else{
	                    answer[i] = arr.get(0);
	                    continue;
	                }
	            }
	            arr.add(score[i]);
	            Collections.sort(arr);
	            answer[i] = arr.get(0);
	        }
	        
	        return answer;
	    }

}
