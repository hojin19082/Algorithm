package Level1;
import java.util.*;
public class 로또의최고순위와최저순위 {


	class Solution {
	    public int[] solution(int[] lottos, int[] win_nums) {
	        int[] answer = new int[2];
	        int zero_count = 0;
	        int count = 0;
	        HashSet<Integer> set = new HashSet<>();
	        for(int i=0; i<win_nums.length; i++){
	            set.add(win_nums[i]);
	        }
	        
	        for(int i=0; i<win_nums.length; i++){
	            if(lottos[i] == 0) zero_count++;
	            else{
	                if(set.contains(lottos[i])){
	                    count++;
	                }
	            }
	        }
	        answer[0] = 7-zero_count-count;
	        answer[1] = 7-count;
	        if(answer[0] == 7) answer[0] = 6;
	        if(answer[1] == 7) answer[1] = 6;
	        return answer;
	    }
	}

}
