package ±¸Çö;

public class CyclicRotation {

	class Solution {
	    public int[] solution(int[] A, int K) {
	        // Implement your solution here
	        if(A.length == K) return A;
	        int[] arr = new int[A.length];
	        for(int i=0; i<A.length; i++){
	            int temp = (i+K)%A.length;
	            arr[temp] = A[i];
	        }

	        return arr;
	    }
	}

}
