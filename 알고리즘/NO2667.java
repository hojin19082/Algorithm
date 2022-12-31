import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NO2667 {

	// N*N ����� ���鼭 1�̸鼭 �湮����� ������ count++ ���ְ� dfs -> �����¿��
	// �������� ���ϴ� �迭�� ���� ������ �������� ���� ���� ������ N*Nũ�⸸ ŭ �迭 ����!
	// �����¿�� dfs�ϸ鼭 �� �̻� �� �� ���� �� count�� ���� 0�� �ƴϸ� �迭�� ����
	// �迭�� N*N ũ�⸦ ������ �ֱ� ������ ���� �� ���ʿ��� N*N-k(������) ���� �����ؼ� ��� ����
	
	private static int graph[][];
	private static boolean visited[][];
	private static int count;
	private static int cnt[];
	private static int N;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new int[N+1][N+1];
		visited = new boolean[N+1][N+1];
		cnt = new int[N*N];
		for(int i=1; i<N+1; i++) {
			String st = br.readLine();
			for(int j=1; j<N+1; j++){
				graph[i][j] = st.charAt(j-1) - '0';
			}
		}
		count=0;
		int k = 0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				dfs(i,j);
					if(count!=0) {
						cnt[k] = count;
						count=0;
						k++;
				}
			}
		}
		
		System.out.println(k);
		Arrays.sort(cnt);
		for(int i=N*N-k; i<N*N; i++) {
			System.out.println(cnt[i]);
		}
		
		
	}
	public static void dfs(int x, int y) {
		if((x>0 && y>0) && (x<N+1 && y<N+1) && (graph[x][y] == 1 && visited[x][y] == false)) {
			count++;
			visited[x][y] = true;
			//�����¿� ��
			dfs(x-1, y);
			dfs(x+1, y);
			dfs(x, y-1);
			dfs(x, y+1);
			}
	}

}
