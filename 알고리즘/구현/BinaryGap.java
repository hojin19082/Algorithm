package ±¸Çö;

public class BinaryGap {

	class Solution {

	    public int solution(int N) {
	        // Implement your solution here
	        if(N == 0) return 0;
	        String arr = Integer.toBinaryString(N);
	        int max = 0;
	        int count = 0;
	        int cnt = 0;
	        for(int i=0; i<arr.length(); i++){
	            char ch = arr.charAt(i);
	            if(ch == '1'){
	                cnt++;
	                if(cnt == 2){
	                    cnt = 1;
	                    max = Math.max(max, count);
	                    count =0;
	                }
	            }else{
	                if(cnt == 1) count++;
	            }
	        }
	        return max;
	    }
	}

}
