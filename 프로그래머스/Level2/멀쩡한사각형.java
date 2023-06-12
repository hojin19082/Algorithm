class Solution {
  //answer가 long타입이므로 int형인 w,h를 long으로 형변환 해줘야 함.
  //둘의 최대 공약수만큼 반복하고
  //최대공약수로 나눈 각 수를 더하고 -1한 값을 최대 공약수 만큼 반복하는 것으로 빼주면 됨.
    public long solution(int w, int h) {
        long answer = (long)w * (long)h;

            int g = gcd(w,h);
            w /= g;
            h /= g;
            int cut = w+h-1;
            answer -= (g * cut);
        
        return answer;
    }
    public static int gcd(int a, int b){
        if(b == 0){
            return a;
        }else{
            return gcd(b, a%b);
        }
    }
}
