package Level1;
import java.util.*;
public class 모의고사 {


	class Solution {
	    public int[] solution(int[] answers) {
	        int[] answer = new int[3];
	        int[] arr1 = {1,2,3,4,5};
	        int[] arr2 = {2,1,2,3,2,4,2,5};
	        int[] arr3 = {3,3,1,1,2,2,4,4,5,5};
	        
	        for(int i=0; i<answers.length; i++){
	            if(answers[i] == arr1[i%5]){
	                answer[0]++;
	            }
	            if(answers[i] == arr2[i%8]){
	                answer[1]++;
	            }
	            if(answers[i] == arr3[i%10]){
	                answer[2]++;
	            }
	        }
	        int max = Math.max(answer[0], Math.max(answer[1], answer[2]));
	        
	        ArrayList<Integer> arr = new ArrayList<>();
	        for(int i=0; i<answer.length; i++){
	            if(max == answer[i]) {
	                arr.add(i+1);
	            }
	        }
	        
	        int[] an = new int[arr.size()];
	        for(int i=0; i<arr.size(); i++){
	            an[i] = arr.get(i);
	        }
	        return an;
	    }
	}

}
