package Level2;
import java.util.*;
public class Å¸°Ù³Ñ¹ö {


	    static ArrayList<Integer> arr;
	    static int answer = 0;
	    public int solution(int[] numbers, int target) {
	        arr = new ArrayList<>();
	        for(int i=0; i<numbers.length; i++){
	            dfs(i, 0, numbers, target);
	        }
	        return answer;
	    }
	    
	    public static void dfs(int count, int start, int[] numbers, int target){
	        if(count == 0){
	            int sum = 0;
	            int[] temp = new int[numbers.length];
	            for(int i=0; i<arr.size(); i++){
	                temp[arr.get(i)] = 1;
	            }
	            for(int i=0; i<numbers.length; i++){
	                if(temp[i] == 1){
	                    sum-=numbers[i];
	                }else{
	                    sum+=numbers[i];
	                }
	            }
	            if(sum == target){
	                answer++;
	            }
	            
	            return;
	        }
	        
	        for(int i=start; i<numbers.length; i++){
	            arr.add(i);
	            dfs(count-1, i+1, numbers, target);
	            arr.remove(arr.size()-1);
	        }
	    }
	}


