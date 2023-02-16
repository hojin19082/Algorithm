package Level1;
import java.util.*;
public class 과일장수 {

	 public int solution(int k, int m, int[] score) {
	        int answer = 0;
	        int size = score.length;
	        int cnt = size/m;
	        int apple = size - cnt * m;
	        Arrays.sort(score);
	        int min =k+1;
	        int count =0;
	        for(int i=apple; i<size; i++){
	            if(min > score[i]){
	                min = score[i];
	            }
	            count++;
	            if(count == m){
	                answer = answer + min * m;
	                count = 0;
	                min = k+1;
	            }
	        }
	        return answer;
	    }

}
