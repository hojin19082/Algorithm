import java.util.*;
class Solution {
    static int answer = 0;
    static int[] prime;
    static String number = "";
    static boolean[] visited;
    static boolean[] primeVisited;
    
    public int solution(String numbers) {
        prime = new int[10000000];
        primeVisited = new boolean[10000000];
        number = numbers;
        visited = new boolean[number.length()];
        for(int i=0; i<prime.length; i++){
            prime[i] = 1;
        }
        for(int i=2; i<prime.length; i++){
            for(int j=i*2; j<prime.length; j+=i){
                prime[j] = 0;
            }
        }
        for(int i=1; i<=number.length(); i++){
            dfs(i, new StringBuilder());
        }
        return answer;
    }
    public static void dfs(int count, StringBuilder sb){
        if(count == sb.length()){
            if(isPrime(Integer.parseInt(sb.toString()))){
                answer++;
            }
            return;
        }
        for(int i=0; i<number.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                sb.append(number.charAt(i));
                dfs(count, sb);
                visited[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    
    public static boolean isPrime(int num){
        if(num!=0 && num!=1 && !primeVisited[num] && prime[num] == 1){
            primeVisited[num] = true;
            return true;
        }
        return false;
    }
}
