package ±¸Çö;

public class TapeEquilibrium {

	class Solution {
	    public int solution(int[] A) {
	        // Implement your solution here
	        int sum = 0;
	        for(int i=0; i<A.length; i++){
	            sum += A[i];
	        }

	        int min = 100001;
	        int a = 0;
	        for(int i=0; i<A.length-1; i++){
	            a += A[i];
	            int b = sum - a;
	            min = Math.min(min, Math.abs(a - b));
	           
	        }
	        return min;
	    }
	}

}
