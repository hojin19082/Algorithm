package Level2;
import java.util.*;
public class 테이블해시함수 {
		//2차원 배열을 정렬하는 법만 알면 쉬움
	    public int solution(int[][] data, int col, int row_begin, int row_end) {
	        int answer = 0;
	        Arrays.sort(data, (o1, o2) -> {
	        	//만약 col-1번째 값이 동일하다면 0번째 col으로 내림차순 정렬
	            if(o1[col-1] == o2[col-1]){
	                return o2[0] - o1[0];
	            }else{
	                return o1[col-1] - o2[col-1];
	            }
	        });
	        int[] S_sum = new int[row_end - row_begin+1];
	        int t = 0;
	        for(int i=row_begin-1; i<row_end; i++){
	            for(int j=0; j<data[i].length; j++){
	                S_sum[t] += (data[i][j] % (i+1));
	            }
	            t++;
	        }
	        answer = S_sum[0];
	        //XOR 연산 -> ^
	        for(int i=1; i<t; i++){
	            answer = answer ^ S_sum[i];
	        }
	        return answer;
	    }

}
