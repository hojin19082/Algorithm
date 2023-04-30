package Level3;
import java.util.*;
public class ��ũ��Ʈ�� {
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
	            //*****�۾��ð��� ������ ���� ��û���� pq�� �����ϱ�*****
	            while(jobs_index < jobs.length && jobs[jobs_index][0] <= end){
	                pq.add(new Disk(jobs[jobs_index][0], jobs[jobs_index][1]));
	                jobs_index++;
	            }
	            //���� pq�� ��������� end�� ���� index�� ��û�ð����� ����
	            if(pq.isEmpty()){
	                end = jobs[jobs_index][0];
	            }else{
	                //pq���� �ϳ��� ���� �� 
	                //���ð� ���ϱ�
	                //end�� �ɸ��� �ð��� ������
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
