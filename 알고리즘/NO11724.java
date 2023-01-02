import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NO11724 {

	private static int N,M;
	private static int g[][];
	private static boolean visited[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int count = 0;
		g = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			visited[i] = false;
		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				g[i][j] = 0;
			}
		}

			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				g[a][b] = 1;
				g[b][a] = 1;
			}
			for(int i=1; i<=N; i++) {
				if(!visited[i]) {
					dfs(i);
					count++;
				}
			}
		System.out.println(count);
	}
	public static void dfs(int a) {
			visited[a] = true;
			for(int k=1;k<=N; k++) {
				if(g[a][k] == 1 && !visited[k])
				dfs(k);
			}
		}
	}
