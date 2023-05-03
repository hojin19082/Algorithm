package Level2;
import java.util.*;
public class 디펜스게임 {
		//최소힙 - pq의 개수가 k보다 클때 가장 작은 수를 뽑아서 적을 처치
		//n이 0보다 작아졌을 때 index가 최대라운드
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

