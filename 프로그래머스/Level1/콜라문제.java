package Level1;

public class �ݶ��� {

	public int solution(int a, int b, int n) {
        int answer = 0;
        while(n-a>=0){
            int temp = (n/a) * b;
            answer += temp;
            n = n - ((n/a) * a) + temp;
        }
        return answer;
    }

}
