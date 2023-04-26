package 자료구조;
import java.util.*;
public class 전광판문구출력 {


	    public String solution(String phrases, int second) {
	        
					String answer = "";
					Queue<Character> q = new LinkedList<>();
					int length = second % (phrases.length()*2);
					if(length == 0) {
						for(int i=0; i<phrases.length(); i++){
							answer+="_";
						}
						return answer;
					}
					for(int i=0; i<14; i++){
						q.offer('_');
					}
				
					for(int i=0; i<length; i++){
						if(i<14){
							q.poll();
							q.offer(phrases.charAt(i));
						}else if(i>13 && phrases.length() - i > 0){
							q.poll();
							q.offer(phrases.charAt(i));
						}else{
							q.poll();
							q.offer('_');
						}
					}
					
				while(!q.isEmpty()){
					answer += q.poll() +"";
				}
				
	        return answer;
	    }
	    
}
