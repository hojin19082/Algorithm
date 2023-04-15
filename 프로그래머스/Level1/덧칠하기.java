package Level1;

public class µ¡Ä¥ÇÏ±â {

	class Solution {
	    public int solution(int n, int m, int[] section) {
	        int answer = 1;
	        int start = section[0];
	        for(int i=1; i<section.length; i++){
	            if(section[i] > start + m -1){
	                answer++;
	                start = section[i];
	            }
	        }
	       
	        
	        return answer;
	    }
	}

}
