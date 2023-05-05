package Level3;
import java.util.*;
public class 단어변환 {

	    static int answer = Integer.MAX_VALUE;
	    static boolean[] visited;
	    public int solution(String begin, String target, String[] words) {
	        visited = new boolean[words.length];
	        if(!Arrays.asList(words).contains(target)) answer = 0;
	        else{
	            for(int i=1; i<=words.length; i++){
	                dfs(0, i, words, begin, target);
	            }
	        }
	        if(answer == Integer.MAX_VALUE) answer = 0;
	        return answer;
	    }
	    
	    public static void dfs(int count, int n, String[] words, String begin, String target){
	        
	        if(count == n){
	            if(begin.equals(target)){
	                answer = Math.min(answer, n);
	            }
	            return;
	        }
	        for(int i=0; i<words.length; i++){
	            if(!visited[i]){
	                char[] str = words[i].toCharArray();
	                int cnt = 0;
	                for(int j=0; j<str.length; j++){
	                    if(str[j] == begin.charAt(j)) cnt++;
	                }

	                if(cnt == begin.length()-1){
	                    visited[i] = true;
	                    dfs(count+1, n, words, words[i], target);
	                    visited[i] = false;
	                }
	                
	            }
	            
	            
	        }
	    }

}
