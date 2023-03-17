package ±¸Çö;

import java.util.*;
public class OddOccurrencesInArray {

	class Solution {
	    public int solution(int[] A) {
	        // Implement your solution here
	        int count = 1;
	        Arrays.sort(A);
	        int value = A[0];
	        for(int i=1; i<A.length; i++){
	            if(value == A[i]){
	                count++;
	            }else{
	                if(count % 2 == 1){
	                    break;
	                }else{
	                    value = A[i];
	                    count=1;
	                }
	                
	            }

	        }
	        
	        return value;
	    }
	}

}
