import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Prim {
	public static class Edge {
		int vertex, weight;
		
		public Edge(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
	
	static int nV;
	static int nE;
	static int final_cost;
	public static List<Edge>[] edge;
	public static int[] minEdge;
	public static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		nV = Integer.parseInt(st.nextToken());
		nE = Integer.parseInt(st.nextToken());
		
		// 간선으로 이어진 노드 두개와 weight 한개 저장
		edge = new ArrayList[nV + 1];
		
		for (int i = 0; i <= nV; ++i) {
			edge[i] = new ArrayList<Edge>();
		}
		
		for (int i = 0; i < nE; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edge[from].add(new Edge(to, weight));
			edge[to].add(new Edge(from, weight));
		}
		
		visited = new boolean[nV + 1];
		final_cost= 0;
		minEdge = new int[nV + 1];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[1] = 0;
		
		for(int i=1; i<=nV; i++) {
			int min = Integer.MAX_VALUE;
			int cur = 0;
			
			for(int j=1; j<=nV; j++) {
				if(!visited[j] &&  min > minEdge[j]) {
					min = minEdge[j];
					cur = j;
				}
			}
			// 집합에 들어간 노드들
			visited[cur] = true;
			final_cost += min;
			
			for (int j = 0; j < edge[cur].size(); ++j) {
				Edge e = edge[cur].get(j);
				
				if (!visited[e.vertex] && minEdge[e.vertex] > e.weight) {
					minEdge[e.vertex] = e.weight;
				}
			}
		}
		System.out.println(final_cost);
	}

}
