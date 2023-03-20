package 구현;

public class 팰린드롬 {

	class Solution {
	    public int solution(int n, int m) {
	        int answer = 0;

	        for(int i = n; i <=m; i++) {
	            if(checkPalindrom(i + "")) {
	                answer++;
	            }
	        }
	        return answer;
	    }
	  
	    private boolean checkPalindrom(String arg) {
	        int j = arg.length() - 1;
	        for (int i = 0; i < arg.length() / 2; i++, j--) {
	            if (arg.charAt(i) != arg.charAt(j)) {
	                return false;
	            }
	        }
	        return true;
	    }
	}

}
