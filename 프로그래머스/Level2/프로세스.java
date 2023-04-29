package Level2;
import java.util.*;
public class 프로세스 {


	class Solution {
	    class Process{
	        char ch;
	        int rank;
	        Process(char ch, int rank){
	            this.ch = ch;
	            this.rank = rank;
	        }
	    }
	    public int solution(int[] priorities, int location) {
	        int answer = 0;
	        Queue<Process> q = new LinkedList<>();
	        ArrayList<Integer> list = new ArrayList<>();
	        for(int i=0; i<priorities.length; i++){
	            q.offer(new Process((char) (i+'A'), priorities[i]));
	            list.add(priorities[i]);
	        }
	        Collections.sort(list, Collections.reverseOrder());
	        char al = (char)(location + 'A');
	        int size = q.size();
	        while(!q.isEmpty()){
	            Process p = q.poll();
	            if(p.rank < list.get(0)){
	                q.offer(p);
	            }else{
	                list.remove(0);
	                
	                if(al == p.ch){
	                    answer = size - q.size();
	                    break;
	                }
	            }
	            
	        }
	        return answer;
	    }
	}

}
