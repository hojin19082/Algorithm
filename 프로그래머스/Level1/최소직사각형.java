package Level1;

public class �ּ����簢�� {

	class Solution {
	    public int solution(int[][] sizes) {
	        int max_v = 0;
	        int max_h = 0;
	        //����, ���� �� �� �亯�� ���η�
	        //���� ���� ���η� �д�.
	        //������ ���� ū ����(����) ���� ���� ����(����) �� ���ؼ� �� ū������
	        
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
