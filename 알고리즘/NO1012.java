import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NO1012 {

	private static int map[][];
	private static boolean visited[][];
	private static int M, N, cnt;
	private static int[] dx = { 0, -1, 0, 1 };
	private static int[] dy = { 1, 0, -1, 0 };
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			map = new int[M][N];
			visited = new boolean[M][N];
			
			for(int x=0; x<M; x++) {
				for(int y=0; y<N; y++) {
					map[x][y] = 0;
					visited[x][y] = false;
				}
			}
			int K = Integer.parseInt(st.nextToken());
			
			int count = 0;
			for(int j=0; j<K; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				map[a][b] = 1;
			}
			
			for(int x=0; x<M; x++) {
				for(int y=0; y<N; y++) {
					if(map[x][y] == 1 && !visited[x][y]) {
						dfs(x,y);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];

			if (cx >= 0 && cy >= 0 && cx < M && cy < N) {
				if (!visited[cx][cy] && map[cx][cy] == 1) {
					dfs(cx, cy);
				}
			}

		}
	}
}