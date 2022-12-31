import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NO2667 {

	// N*N 행렬을 돌면서 1이면서 방문기록이 없으면 count++ 해주고 dfs -> 상하좌우로
	// 단지수를 구하는 배열은 이중 포문을 돌때마다 값이 들어가기 때문에 N*N크기만 큼 배열 선언!
	// 상하좌우로 dfs하면서 더 이상 갈 수 없을 때 count의 값이 0이 아니면 배열에 저장
	// 배열은 N*N 크기를 가지고 있기 때문에 정렬 후 뒤쪽에서 N*N-k(단지수) 부터 시작해서 출력 시작
	
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
			//상하좌우 순
			dfs(x-1, y);
			dfs(x+1, y);
			dfs(x, y-1);
			dfs(x, y+1);
			}
	}

}
