import java.io.*;
import java.util.*;

public class NO11724 {
	static int[][] map;
	static boolean[] visited;
	static int n, m;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		for(int i=1; i<n+1; i++) {
			for (int j=1; j<n+1; j++) {
				map[i][j] = 0;
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			map[u][v] = 1;
			map[v][u] = 1;
		}
		
		int cnt=0;
		
		for(int i=1; i<n+1; i++) {
			if(!visited[i]) {
				dfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	public static void dfs(int start) {
		visited[start] = true;
		for (int i = 1; i < n + 1; i++) {
			if (!visited[i] && map[start][i] == 1) {
				dfs(i);
			}
		}
	}
}
