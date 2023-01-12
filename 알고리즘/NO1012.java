import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NO1012 {

	private static int map[][];
	private static boolean visited[][];
	private static int M, N;
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
		if((x>=0 && y>=0) && (x<M && y<N) && (map[x][y] == 1 && visited[x][y] == false)) {
			visited[x][y] = true;
			//»óÇÏÁÂ¿ì ¼ø
			dfs(x-1, y);
			dfs(x+1, y);
			dfs(x, y-1);
			dfs(x, y+1);
			}
	}
}