package Level2;
import java.util.*;
public class HINDEX {
	//h편 이상 인용된 논문이 논문의 개수와 동일할 수 있기 때문에
	//h값의 범위는 0~논문의 개수까지 봐야함 -> 따라서  for(int i=0; i<citations.length+1; i++)로 정의
	class Solution {
	    public int solution(int[] citations) {
	        int answer = 0;
	        int length = citations.length;
	        Arrays.sort(citations);
	        for(int i=0; i<citations.length+1; i++){
	            int h = i;
	            int count = 0;
	            for(int j=0; j<citations.length; j++){
	                if(h <= citations[j]){
	                    count++;
	                }
	            }
	            if(h<=count){
	                answer = Math.max(answer, h);
	            }
	        }
	        
	        return answer;
	    }
	}

}
