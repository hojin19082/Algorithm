import java.io.*;
import java.util.*;
public class dijkstra {
	
	public static class Edge{
		int v;
		int weight;
		
		public Edge(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}
	}
	
	static int n,m;
	static long[] d;
	static List<Edge>[] edge;
	static boolean visited[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		edge = new ArrayList[n+1];
		
		for(int i=1; i<n+1; i++) {
			edge[i] = new ArrayList<Edge>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edge[u].add(new Edge(v, weight));
		}
		
		d = new long[n+1];
		for(int i=1; i<n+1; i++) {
			d[i] = Integer.MAX_VALUE;
		}
		visited = new boolean[n+1];
		
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		dijkstra(s);
		if(d[t] == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(d[t]);	
		}
	}
	
	public static void dijkstra(int s) {
		d[s] = 0;
		for(int i=0; i<n; i++) {
			int cur = s;
			long min = Integer.MAX_VALUE;
			for(int j=1; j<n+1; j++) {
				if(!visited[j] && min>d[j]) {
					min = d[j];
					s = j;
				}
			}
			visited[cur] = true;
			for(int j=0; j<edge[cur].size(); j++) {
				Edge e = edge[cur].get(j);
				if(d[e.v] > d[cur] + e.weight) {
					d[e.v] = d[cur] + e.weight;
				}
			}
		}
	}
}
