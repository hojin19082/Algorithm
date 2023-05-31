package Level2;
import java.util.*;
public class 두큐합같게만들기 {
	//큐의 최대 길이가 300000이므로
	//만약 60만번이 넘어가면 똑같은 큐로 돌아오는 것이므로 break!
	    public int solution(int[] queue1, int[] queue2) {
	        int answer = 0;
	        Queue<Integer> q1 = new LinkedList<>();
	        Queue<Integer> q2 = new LinkedList<>();
	        
	        long sum1 = 0;
	        long sum2 = 0;
	        for(int i=0; i<queue1.length; i++){
	            sum1 += (long)queue1[i];
	            q1.offer(queue1[i]);
	            sum2 += (long)queue2[i];
	            q2.offer(queue2[i]);
	        }
	        
	        while(!q1.isEmpty() && !q2.isEmpty()){
	            if(sum1 == sum2){
	                break;
	            }
	            if(answer > 600000) {
	                answer = -1;
	                break;
	            }
	            if(sum1>sum2){
	                int pop = q1.poll();
	                sum1 -= pop;
	                sum2 += pop;
	                q2.offer(pop);
	            }else{
	                int pop = q2.poll();
	                sum2 -= pop;
	                sum1 += pop;
	                q1.offer(pop);
	            }
	            answer++;
	        }
	        if(q1.isEmpty() || q2.isEmpty()){
	            answer = -1;
	        }
	        
	        return answer;
	    }
}
