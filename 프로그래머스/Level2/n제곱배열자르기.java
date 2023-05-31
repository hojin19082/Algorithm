package Level2;

public class n제곱배열자르기 {
	//n==3일 경우
	// (1,1) (1,2) (1,3)
	// (2,1) (2,2) (2,3)
	// (3,1) (3,2) (3,3)
	//x,y 중 큰 값이 각 칸에 들어가는 값!
	//따라서, left부터 시작해서 right까지
	//몫, 나머지를 통해 더 큰 값을 배열에 저장
	    public int[] solution(int n, long left, long right) {
	        int[] answer = new int[(int)(right-left)+1];
	        for(int i=0; i<answer.length; i++){
	            int y = (int)(left / n) + 1;
	            int x = (int)(left % n) + 1;
	            left++;
	            answer[i] = Math.max(x,y);
	        }
	        return answer;
	    }

}
