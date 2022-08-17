import java.util.*;
import java.io.*;

class Edge{
	int u;
	int v;
	int weight;
	
	public Edge(int u, int v, int weight){
		this.u = u;
		this.v = v;
		this.weight = weight;
	}
}

public class bellman {
	static int n,m;
	static Edge[] edge;
	static long[] d;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		edge = new Edge[m];
		
		// 가중치 방향 그래프,, edge[i]에서 to(j) i -> j
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edge[i] = new Edge(u,v,weight);
		}
		
		d = new long[n+1];
		for(int i=1; i<n+1; i++) {
			d[i] = Integer.MAX_VALUE;
		}
	

		if(bellman(1)) {
			System.out.println(-1);
		}else {
			for(int i=2; i<n+1; i++) {
				if(d[i] == Integer.MAX_VALUE) {
					System.out.println(-1);
				}else {
					System.out.println(d[i]);
				}
			}
		}
		
	}
	public static boolean bellman(int s) {
		d[s] = 0;
		
		// n번 
		for(int i=0; i<n; i++) {
			
			for(int j=0; j<m; j++) {
				int cur = edge[j].u;
				int next = edge[j].v;
				int cost = edge[j].weight;
				
				if(d[cur] == Integer.MAX_VALUE) {
					continue;
				}
				
				if(d[next] > (d[cur] + cost)) {
					d[next] = d[cur] + cost;
					
					if(i==n-1) {
						return true;
					}
				}
			}
			
		}
		return false;
	}
}
