package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class NO1753 {
	private static int V,E,K;
//	private static int[][] map;
	private static int[] d;
	private static boolean[] visited;
	private static int INF = Integer.MAX_VALUE;
	private static LinkedList<Edge> map[];
		
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		map = new LinkedList[V+1];
		visited = new boolean[V+1];
		d = new int[V+1];
		for(int i=1; i<V+1; i++) {
			map[i] = new LinkedList();
			d[i] = INF;
		}
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			map[u].add(new Edge(v,w));
		}
		
		d[K] = 0;
		dijkstra(K);
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<V+1; i++) {
			sb.append(d[i] == INF ? "INF" : d[i]).append('\n');
		}
		System.out.print(sb.toString());
	}
	static class Edge implements Comparable<Edge>{
		int number, weight;
		
		Edge(int v, int w){
			this.number = v;
			this.weight = w;
		}
		public int compareTo(Edge n) {
			return weight - n.weight;
		}
	}
	public static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.offer(new Edge(start, 0));
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			for(Edge next : map[now.number]) {
				if(d[next.number] > now.weight + next.weight) {
					d[next.number] = now.weight + next.weight;
					pq.offer(new Edge(next.number, d[next.number]));
				}
			}
		}
	}

}
