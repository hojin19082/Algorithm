
public class powerset {
	private static char data[] = {'a','b','c','d','e','f'};
	private static int n=data.length;
	private static boolean[] include = new boolean [n];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		powerset(0);
	}

	// include�� k�� ���� � ��ġ�� �ִ��� Ȯ��
	public static void powerset(int k) {
		//�� ������ �ܰ�
		if (k==n) {
			for (int i=0; i<n; i++) {
				if(include[i]) System.out.print(data[i] + " ");
			}
			System.out.println();
			return;
			}
		//���� �������� �������ٰ� (���� k ��ġ�� �ִ� ���� �������� �ʰ�)
		include[k] = false;
		powerset(k+1);
		// ������ ������ �Ʒ��� ������ (�����ϰ�)
		include[k] = true;
		powerset(k+1);
	}
}
