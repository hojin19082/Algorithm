public class NQueens {
	private static int N = 5;
	private static int [] cols = new int [N+1];
	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		if(queens(N, 0)) {
			System.out.println("Exists");
		}else {
			System.out.println("Not exist");
		}
	}

	public static boolean queens(int N, int level) {
		if (!promising(level)) {
			return false;
		}else if (level == N) {
			for(int i=1; i<=N; i++) {
				System.out.println("(" + i +", " + cols[i] + ")");
			}
			return true;
		}else {
			for(int i=1; i<=N; i++) {
				cols[level+1] = i;
				if(queens(N, level+1)) {
					return true;
				}
			}
			return false;
		}
	}
	
	public static boolean promising(int level) {
		for (int i=1; i<level; i++) {
			// 같은 열에 있는지
			if(cols[i] == cols[level]) {
				return false;
			} //대각선에 있는지
			else if(level-i == Math.abs(cols[level] -cols[i])){
				return false;
			}
		}
		return true;
	}
}
