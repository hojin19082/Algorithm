package Level1;

public class 삼진법뒤집기 {


class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb  = new StringBuilder();
        while(n/3 >0){
            sb.append(n%3);
            n/=3;
        }
        sb.append(n);
        int k = 1;
        for(int i=sb.length()-1; i>=0; i--){
            int num = sb.charAt(i) - '0';
            answer += (num*k);
            k *=3;
        }
        
        return answer;
    }
}

}
