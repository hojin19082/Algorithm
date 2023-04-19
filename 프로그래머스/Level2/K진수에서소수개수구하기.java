package Level2;

public class K진수에서소수개수구하기 {

	class Solution {
	    public int solution(int n, int k) {
	        int answer = 0;
	        String sb = "";
	        //k진수 변환
	        while(n/k>0){
	            sb += String.valueOf(n%k);
	            n/=k;
	        }
	        sb += String.valueOf(n);
	        StringBuilder sbr = new StringBuilder();
	        sbr.append(sb);
	        sb = String.valueOf(sbr.reverse());
	        String[] arr = sb.split("0");
	        for(int i=0; i<arr.length; i++){
	            if(arr[i].equals("")) continue;
	            Long num = Long.parseLong(arr[i]);
	            if(num!=1 && isPrime(num)){
	                answer++;
	            }
	        }
	        
	        return answer;
	    }
	    
	    public boolean isPrime(long num){
	        int count = 0;
	        for(int i=1; i<=Math.sqrt(num); i++){
	            if(num%i == 0){
	                count+=2;
	            }
	            if(count > 2) break;
	        }
	        if(count == 2) return true;
	        else return false;
	    }
	}

}
