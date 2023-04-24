package Level1;

public class 비밀지도 {

	class Solution {
	    public String[] solution(int n, int[] arr1, int[] arr2) {
	        String[] answer = new String[n];
	        for(int i=0; i<n; i++){
	            String bit1 = Integer.toString(arr1[i], 2);
	            if(bit1.length() != n){
	                int count = n-bit1.length();
	                bit1 = "0".repeat(count) + bit1;
	            }
	            String bit2 = Integer.toString(arr2[i], 2);
	            if(bit2.length() != n){
	                int count = n-bit2.length();
	                bit2 = "0".repeat(count) + bit2;
	            }
	            answer[i] = "";
	            for(int j=0; j<n; j++){
	                if(bit1.charAt(j) == '1' || bit2.charAt(j) == '1'){
	                    answer[i] += '#'+"";
	                }else{
	                    answer[i] += " ";
	                }
	            }
	        }

	        return answer;
	    }
	}

}
