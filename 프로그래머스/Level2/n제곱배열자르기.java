package Level2;

public class n�����迭�ڸ��� {
	//n==3�� ���
	// (1,1) (1,2) (1,3)
	// (2,1) (2,2) (2,3)
	// (3,1) (3,2) (3,3)
	//x,y �� ū ���� �� ĭ�� ���� ��!
	//����, left���� �����ؼ� right����
	//��, �������� ���� �� ū ���� �迭�� ����
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
