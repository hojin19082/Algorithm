package Level1;
import java.util.*;
public class 배열자르고정렬후K번째수 {

	class Solution {
	    public int[] solution(int[] array, int[][] commands) {
	        int[] answer = new int[commands.length];
	        
	        for(int i=0; i<commands.length; i++){
	            int[] arr = new int[commands[i][1] - commands[i][0] +1];
	            int t = 0;
	            for(int j = commands[i][0]-1; j<commands[i][1]; j++){
	                arr[t++] = array[j];
	            }
	            Arrays.sort(arr);
	            answer[i] = arr[commands[i][2]-1];
	        }
	        
	        return answer;
	    }
	}

}
