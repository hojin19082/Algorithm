package Level2;
import java.util.*;
public class ���̺��ؽ��Լ� {
		//2���� �迭�� �����ϴ� ���� �˸� ����
	    public int solution(int[][] data, int col, int row_begin, int row_end) {
	        int answer = 0;
	        Arrays.sort(data, (o1, o2) -> {
	        	//���� col-1��° ���� �����ϴٸ� 0��° col���� �������� ����
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
	        //XOR ���� -> ^
	        for(int i=1; i<t; i++){
	            answer = answer ^ S_sum[i];
	        }
	        return answer;
	    }

}
