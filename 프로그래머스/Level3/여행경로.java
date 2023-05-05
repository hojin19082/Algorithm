package Level3;
import java.util.*;
public class 여행경로 {

	    static boolean[] visited;
	    static ArrayList<String> arr;
	    public String[] solution(String[][] tickets) {
	        visited = new boolean[tickets.length];
	        arr = new ArrayList<>();
	        
	        dfs("ICN",  0, tickets, "ICN ");
	        Collections.sort(arr);
	 
	        String[] answer = arr.get(0).split(" ");
	        return answer;
	    }
	    public static void dfs(String begin, int count, String[][] tickets, String current){
	        if(count == tickets.length){
	            arr.add(current);
	            return;
	        }
	        
	        for(int i=0; i<tickets.length; i++){
	            if(!visited[i] && tickets[i][0].equals(begin)){
	                visited[i] = true;
	                dfs(tickets[i][1], count+1, tickets, current + tickets[i][1] + " ");
	                visited[i] = false;
	            }
	        }
	    
	}
}
