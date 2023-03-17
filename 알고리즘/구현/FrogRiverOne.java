package ±¸Çö;
import java.util.*;
public class FrogRiverOne {

	
	class Solution {
	    public int solution(int X, int[] A) {
	        // Implement your solution here
	       int[] arr = new int[X+1];
	       Arrays.fill(arr, -1);
	       int count = 0;
	       int value = -1;
	       for(int i=0; i<A.length; i++){
	           if(arr[A[i]] == -1){
	               arr[A[i]] = i;
	               count++;
	           }

	           if(count == X){
	               value = i;
	                break;
	           }
	       }

	      return value;
	    }
	}
}
