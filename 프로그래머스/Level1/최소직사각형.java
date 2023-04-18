package Level1;

public class 최소직사각형 {

	class Solution {
	    public int solution(int[][] sizes) {
	        int max_v = 0;
	        int max_h = 0;
	        //가로, 세로 중 더 긴변을 가로로
	        //작은 변을 세로로 둔다.
	        //이전에 가장 큰 가로(세로) 값과 현재 가로(세로) 값 비교해서 더 큰값으로
	        
	        for(int i=0; i<sizes.length; i++){
	            int v = Math.max(sizes[i][0], sizes[i][1]);
	            int h = Math.min(sizes[i][0], sizes[i][1]);
	            max_v = Math.max(max_v, v);
	            max_h = Math.max(max_h, h);
	            
	        }
	        return max_v * max_h;
	    }
	}

}
