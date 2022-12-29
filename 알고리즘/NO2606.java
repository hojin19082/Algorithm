import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NO2606 {
	private static int n,m;
	static class graph{
		private static int count;
		private static LinkedList<Integer> adj[];
		private static boolean visited[];
		
		graph(int v){
			adj = new LinkedList[v+1];
			visited = new boolean[v+1];
			count = 0;
			for(int i=1; i<v+1; i++) {
				adj[i] = new LinkedList();
			}
		}
		
		public static void addEdge(int a, int b) {
			adj[a].add(b);
			adj[b].add(a);
		}
	}
	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		graph g = new graph(n);
		for(int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			g.addEdge(a, b);
		}
		
		dfs(g, 1);
		System.out.println(g.count);
		
	}
	public static void bfs(graph g, int v) {
		g.visited[v] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(v);
		while(!queue.isEmpty()) {
			int pop = queue.poll();
			for(int i : g.adj[pop]) {
				if(g.visited[i] == false) {
					g.visited[i] = true;
					queue.add(i);
					g.count++;
				}
			}
		}
	}
	
	public static void dfs(graph g, int v) {
		g.visited[v] = true;
		for(int i: g.adj[v]) {
			if(g.visited[i] == false) {
				g.visited[i] =true;
				dfs(g, i);
				g.count++;
			}
		}
	}
}
