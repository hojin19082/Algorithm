
public class powerset {
	private static char data[] = {'a','b','c','d','e','f'};
	private static int n=data.length;
	private static boolean[] include = new boolean [n];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		powerset(0);
	}

	// include와 k는 현재 어떤 위치에 있는지 확인
	public static void powerset(int k) {
		//맨 마지막 단계
		if (k==n) {
			for (int i=0; i<n; i++) {
				if(include[i]) System.out.print(data[i] + " ");
			}
			System.out.println();
			return;
			}
		//먼저 왼쪽으로 내려갔다가 (현재 k 위치에 있는 값을 포함하지 않고)
		include[k] = false;
		powerset(k+1);
		// 다음은 오른쪽 아래로 내려감 (포함하고)
		include[k] = true;
		powerset(k+1);
	}
}
