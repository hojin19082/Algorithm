package Level1;
import java.util.*;
public class Ã¼À°º¹ {


	class Solution {
	    public int solution(int n, int[] lost, int[] reserve) {
	        int answer = n;
	        int[] person = new int[n+1];
	        Arrays.sort(lost);
	        Arrays.sort(reserve);
	        Arrays.fill(person, 1);
	        
	        for(int i : lost){
	            person[i]--;
	        }
	        for(int i : reserve){
	            person[i]++;
	        }
	        
	        for(int i=1; i<=n; i++){
	            if(person[i] == 0){
	                if(i!=1 && person[i-1] == 2){
	                    person[i]++;
	                    person[i-1]--;
	                }else if(i!=n && person[i+1] == 2){
	                    person[i]++;
	                    person[i+1]--;
	                }
	            }
	        }
	        for(int i=1; i<=n; i++){
	            if(person[i] == 0){
	                answer--;
	            }
	        }
	       
	        return answer;
	    }
	}

}
