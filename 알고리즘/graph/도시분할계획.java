package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 도시분할계획 {
	static ArrayList<Node>[] adj;
	static int v,e;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		adj = new ArrayList[v+1];
		for(int i=1; i<=v; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adj[a].add(new Node(b,c));
			adj[b].add(new Node(a,c));
		}
		
		System.out.println(prim());
	}
	public static long prim() {
		boolean[] visited = new boolean[v+1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1,0));
		
		long res = 0;
		int cnt = 0;
		int max = 0;
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			if(visited[n.to]) continue;
			res += n.weight;
			visited[n.to] = true;
			max = Math.max(max, n.weight);
			if(++cnt == v) return res - max;
			
			for(int i=0; i<adj[n.to].size(); i++) {
				Node next = adj[n.to].get(i);
				if(visited[next.to]) continue;
				pq.add(next);
			}
		}
		return res - max;
	}

}
class Node implements Comparable<Node>{
	int to;
	int weight;
	
	Node(int to, int weight){
		this.to = to;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.weight, o.weight);
	}
}