package Level2;
import java.util.*;
public class ���潺���� {
		//�ּ��� - pq�� ������ k���� Ŭ�� ���� ���� ���� �̾Ƽ� ���� óġ
		//n�� 0���� �۾����� �� index�� �ִ����
	    public int solution(int n, int k, int[] enemy) {
	        int answer = 0;
	        PriorityQueue<Integer> pq = new PriorityQueue<>();
	        if(k >= enemy.length){
	            answer = enemy.length;
	        }else{
	            for(int i = 0 ; i< enemy.length; i++){
	                pq.offer(enemy[i]);
	                if(pq.size() > k){
	                    n-=pq.poll();
	                }
	                
	                if(n<0) return i;
	            }
	        }
	        return enemy.length;
	    }
	}

