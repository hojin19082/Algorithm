package Level1;

public class 크기가_작은_부분_문자열 {

	 public int solution(String t, String p) {
	        int answer = 0;
	        long num = Long.parseLong(p);
	        int i=0;
	        while(i+p.length() <= t.length()){
	            String temp = "";
	            temp = t.substring(i, i+p.length());
	            if(Long.parseLong(temp) <= num){
	                answer++;
	            }
	            i++;
	        }
	        return answer;
	    }

}
