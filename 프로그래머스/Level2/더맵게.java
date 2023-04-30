package Level2;
import java.util.*;
public class ´õ¸Ê°Ô {

	class Solution {
	    public int solution(int[] scoville, int K) {
	        int answer = 0;
	        PriorityQueue<Long> pq = new PriorityQueue<>();
	        for(int i=0; i<scoville.length; i++){
	            pq.offer((long)scoville[i]);
	        }
	        
	            while(true){
	                if(pq.peek() >= K) break;
	                else{
	                    if(pq.size()==1){
	                        answer=-1;
	                        break;
	                    }
	                }
	                long num1 = pq.poll();
	                long num2 = pq.poll();
	                long newScoville = num1 + (num2*2);
	                pq.offer(newScoville);
	                answer++;
	            }
	        
	        
	        return answer;
	    }
	}

}
