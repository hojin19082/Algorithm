package 카카오기출2019;
import java.util.*;
public class 기출 {
	//level1 - 크레인 인형 뽑기
	public int solution(int[][] board, int[] moves){
        int answer = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<moves.length-1; i++){
            for(int j=0; j<board[1].length; j++){
                if(board[j][moves[i]-1] == 0) continue;
                
                if(arr.size() !=0){
                    int pop = arr.remove(arr.size()-1);
                    if(pop == board[j][moves[i]-1]){
                        answer = answer + 2;
                    }else{
                        arr.add(pop);
                        arr.add(board[j][moves[i]-1]);
                    }
                }else{
                    arr.add(board[j][moves[i]-1]);
                }
                board[j][moves[i]-1] = 0;
                break;
            }
        }
        System.out.println(answer);
        return answer;
    }  
	//level2 - 튜플
	public ArrayList<Integer> solution(String s) {
        ArrayList <Integer> answer = new ArrayList<>();
        s = s.substring(2, s.length()-2);
        s = s.replace("},{", "-");
        String[] arr = s.split("-");
        
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String a1, String a2){
                return a1.length() - a2.length();
            }
        });
        
        for(int i=0; i<arr.length; i++){
            String[] temp = arr[i].split(",");
            for(int j=0; j<temp.length; j++){
                int n = Integer.parseInt(temp[j]);
                if(!answer.contains(n)){
                    answer.add(n);
                }
            }
        }
        return answer;
    }
	
	//level3 - 징검다리 건너기
	public int solution(int[] stones, int k) {
        if(stones.length == 1){
            return stones[0];
        }
        int left = 0;
        int max = 0;
        for(int i=0; i<stones.length-1; i++){
            if(max < stones[i]){
                max = stones[i];
            }
        }
        int right = max;
        while(left < right){
            int mid = (left+right)/2;
            int count=0;
            for(int i=0; i<stones.length; i++){
                if(mid >= stones[i]){
                    count++;
                    if(count == k){
                        break;
                    }
                }else{
                    count = 0;
                }
            }
        
            if(count == k) {
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return right;
    }
	
	//level3 - 불량 사용자
	 HashSet<String> set;
	    boolean[] visited;
	    public int solution(String[] user_id, String[] banned_id) {
	        set = new HashSet<>();
	        for(int i=0; i<banned_id.length; i++){
	            banned_id[i] = banned_id[i].replace("*", ".");
	        }
	        visited = new boolean[user_id.length];
	        backtracking(0, "", user_id, banned_id);
	        return set.size();
	    }
	    public void backtracking(int idx, String result, String[] user, String[] ban){
	        if(idx == ban.length){
	            String[] str = result.split(" ");
	            Arrays.sort(str);
	            
	            String newStr = "";
	            for(int i=0; i<str.length; i++){
	                newStr += str[i];
	            }
	            set.add(newStr);
	            return;
	        }
	        
	        for(int i=0; i<user.length; i++){
	            if(!visited[i] && user[i].matches(ban[idx])){
	                visited[i] = true;
	                backtracking(idx + 1, result + " " + user[i], user, ban);
	                visited[i] = false;
	            }
	        }
	    }

}
