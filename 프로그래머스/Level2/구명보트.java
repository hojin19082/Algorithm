package Level2;
import java.util.*;
public class 구명보트 {

	//정렬+투포인터
	    public int solution(int[] people, int limit) {
	        int answer = 0;
	        Arrays.sort(people);
	        int left = 0;
	        int right = people.length -1;
	        while(left <= right){
	            if(people[left] + people[right] > limit){
	                right--;
	            }else{
	                left++;
	                right--;
	            }
	            answer++;
	        }
	        return answer;
	    }
	}


