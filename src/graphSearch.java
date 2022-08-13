import java.util.*;
public class graphSearch {
	static class graph{
		// graph에는 정점의 개수와 인접한 node를 연결하는 adj[]가 linkedlist로 구현
		public int V;
		public LinkedList <Integer> adj[];
		public int d[];
		public Integer fi[];
		public boolean visited[];
		
		graph(int v){
			V = v+1;
			visited = new boolean[V];
			adj = new LinkedList[V];
			for(int i=0; i<V; i++) {
				adj[i] = new LinkedList();
			}
		}
		
		public void addEdge(int a, int b) {
			adj[a].add(b);
			adj[b].add(a);
		}
		public void bfs(int start) {
			Queue<Integer> queue = new LinkedList<Integer>();
			d = new int[V];
			fi = new Integer[V];
			for(int i=0; i<V; i++) {
				d[i] = -1;
				fi[i] = null;
			}
			d[start] = 0;
			fi[start] = null;
			queue.offer(start);
			while(!queue.isEmpty()) {
				int V = queue.poll();
				System.out.print(V + " ");
				for(int i: adj[V]) {
					if(d[i] == -1) {
						d[i] = d[V] + 1;
						fi[i] = V;
						queue.offer(i);
					}
				}
			}
			System.out.println();
		}
		
		public void print_path(int s, int v) {
			if(v==s) {
				System.out.print(s+ " ");
			}else if(fi[v] == null) {
				System.out.println("Not found path");
			}else {
				print_path(s, fi[v]);
				System.out.print(v + " ");
			}
		}
		
		public void dfs(int start) {
			visited[start] = true;
			System.out.print(start + " ");
			for(int i : adj[start]) {
				if(!visited[i]) {
					dfs(i);
				}
			}
		}
	}
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		graph g = new graph(12);
		g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 1);
        g.addEdge(2, 5);
        g.addEdge(2, 6);
        g.addEdge(3, 1);
        g.addEdge(4, 1);
        g.addEdge(4, 7);
        g.addEdge(4, 8);
        g.addEdge(5, 2);
        g.addEdge(5, 9);
        g.addEdge(5, 10);
        g.addEdge(6, 2);
        g.addEdge(7, 4);
        g.addEdge(7, 11);
        g.addEdge(7, 12);
        g.addEdge(8, 4);
        g.addEdge(9, 5);
        g.addEdge(10, 5);
        g.addEdge(11, 7);
        g.addEdge(12, 7);
        
        /*
        System.out.print("BFS: ");
        g.bfs(3);
        
        System.out.print("BFS 시작부터 12까지 최단 경로: ");
        g.print_path(3, 12);
        
        System.out.println();
        System.out.print("BFS 시작부터 2까지 최단 거리: " + g.d[2]);
        */
        
        System.out.print("DFS: ");
        g.dfs(1);
        
	}

}
