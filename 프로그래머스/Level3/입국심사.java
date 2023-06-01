package Level3;
import java.util.*;
public class 입국심사 {
	//정렬 후 가장 큰 값 * n이 최대로 걸릴 수 있는 시간
	//이분탐색으로 각 심사원마다 몫을 더해나가
	//n보다 크면 right을 mid-1로
	//n보다 작으면 left를mid+1로 진행
	//즉 현재 mid초일 때 각 심사원이 몇명을 맡는지 구하는 것!
	    public long solution(int n, int[] times) {
	        long answer = 0;
	        Arrays.sort(times);
	        long left = 0;
	        long right = (long) n * times[times.length-1];
	        while(left<=right){
	            long mid = (left+right)/2;
	            long sum = 0;
	            for(int i=0; i<times.length; i++){
	                sum += mid/times[i];
	            }
	            if(sum < n){
	                left = mid +1;
	            }else{
	                right = mid -1;
	                answer = mid;
	            }
	        }
	        return answer;
	    }

}
