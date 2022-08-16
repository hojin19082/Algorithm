import java.util.*;
import java.io.*;

// kruskal은 간선 위주!
public class Kruskal {
	static int nV;
	static int nE;
	static int[][] graph;
	// 각 노드의 root 노드 저장
	static int[] parent;
	static int final_cost;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		nV = Integer.parseInt(st.nextToken());
		nE = Integer.parseInt(st.nextToken());
		
		// 간선으로 이어진 노드 두개와 weight 한개 저장
		graph = new int[nE][3];
		
		for (int i=0; i<nE; i++) {
			st = new StringTokenizer(br.readLine());
			graph[i][0] = Integer.parseInt(st.nextToken());
			graph[i][1] = Integer.parseInt(st.nextToken());
			graph[i][2] = Integer.parseInt(st.nextToken());
		}
		
		parent = new int[nV];
		final_cost= 0;
		
		// 가중치로 정렬을 해야하기 때문에 조건을 o1[2], o2[2]로 지정
		Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));
		
		// makeSet
		for (int i=0; i<nV; i++) {
			parent[i] = i;
		}
		
		
		for(int i=0; i<nE; i++) {
			if(find(graph[i][0] - 1) != find(graph[i][1] -1 )) {
				System.out.println("선택된 간선");
				System.out.println(graph[i][0] + ", " +graph[i][1]);
				union(graph[i][0] -1, graph[i][1] -1);
				final_cost += graph[i][2];
			}
		}
		System.out.println("각 노드의 root 노드");
		System.out.println(Arrays.toString(parent) +"\n");
		System.out.println("최종 비용: " + final_cost);
	}
	
	private static int find(int x) {
		if (parent[x] == x) {
			return x;
		}else {
			return find(parent[x]);
		}
	}
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a>b) {
			parent[b] =a;
		}else {
			parent[a] =b;
		}
	}
}
