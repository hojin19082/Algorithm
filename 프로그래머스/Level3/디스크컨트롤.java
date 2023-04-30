package Level3;
import java.util.*;
public class 디스크컨트롤 {
	class Solution {
	    class Disk{
	        int request, take;
	        Disk(int request, int take){
	            this.request = request;
	            this.take = take;
	        }
	    }
	    public int solution(int[][] jobs) {
	        int answer = 0;
	        Arrays.sort(jobs, (o1,o2)->o1[0] - o2[0]);
	        PriorityQueue<Disk> pq = new PriorityQueue<>(Comparator.comparingInt(Disk->Disk.take));
	        int count = 0;
	        int end = 0;
	        int jobs_index = 0;
	        while(count < jobs.length){
	            //*****작업시간의 끝보다 작은 요청들을 pq에 저장하기*****
	            while(jobs_index < jobs.length && jobs[jobs_index][0] <= end){
	                pq.add(new Disk(jobs[jobs_index][0], jobs[jobs_index][1]));
	                jobs_index++;
	            }
	            //만약 pq가 비어있으면 end는 현재 index의 요청시간으로 지정
	            if(pq.isEmpty()){
	                end = jobs[jobs_index][0];
	            }else{
	                //pq에서 하나씩 뽑은 후 
	                //대기시간 구하기
	                //end는 걸리는 시간을 더해줌
	                Disk disk = pq.poll();
	                answer += disk.take + end - disk.request;
	                end += disk.take;
	                count++;
	            }
	            
	        }
	        
	        return (int) answer / jobs.length;
	    }
	}

}
