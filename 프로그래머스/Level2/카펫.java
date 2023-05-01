package Level2;

public class Ä«Æê {
	
	class Solution {
	    public int[] solution(int brown, int yellow) {
	        int[] answer = new int[2];
	        int count = brown + yellow;
	        for(int i=1; i<=Math.sqrt(count); i++){
	            if(count % i == 0){
	                int num1 = i;
	                int num2 = count / i;
	                
	                if(num2 * 2 + ((num1 * 2)-4) == brown){
	                    answer[0] = num2;
	                    answer[1] = num1;
	                    break;
	                }
	            }
	        }
	        return answer;
	    }
	}

}
