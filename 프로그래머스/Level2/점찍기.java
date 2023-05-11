class Solution {
    //범위는 알 수 있으므로 각 반복문의 index를 x좌표라고 생각
    //d와 x좌표를 이용하여 y좌표 유추하여 개수 계산.
    public long solution(int k, int d) {
        long answer = 0;
        for(int i=0; i<d+1; i+=k){
            answer += Math.floor(Math.floor(Math.sqrt(Math.pow(d,2) - Math.pow(i, 2))/k) +1);
        }
        return answer;
    }
}
