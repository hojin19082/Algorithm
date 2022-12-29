import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class NO1260 {
	//그래프 기본 dfs, bfs 구현
	
	private static int graph[][];
	private static boolean visited[];
	private static int n,m,v;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		visited = new boolean[n+1];
		graph = new int[n+1][n+1];
		initial(visited);
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				graph[i][j] = 0;
			}
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		dfs(v);
		initial(visited);
		System.out.println();
		bfs(v);
		
	}

	public static void dfs(int v) {
		visited[v] = true;
		System.out.print(v +" ");
		for(int i=1; i<=n; i++) {
			if(graph[v][i] == 1 && visited[i] == false) {
				dfs(i);
			}
		}
	}
	
	public static void bfs(int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		visited[v] = true;
		q.add(v);
		while(!q.isEmpty()) {
			int pop = q.poll();
			System.out.print(pop + " ");
			for(int i=1; i<=n; i++) {
				if(graph[pop][i] == 1 && visited[i] == false) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
		
	}
	public static void initial(boolean[] visited) {
		for(int i=1; i<=n; i++) {
			visited[i] = false;
		}
	}
}
