import java.util.*;
import java.io.*;

// kruskal�� ���� ����!
public class Kruskal {
	static int nV;
	static int nE;
	static int[][] graph;
	// �� ����� root ��� ����
	static int[] parent;
	static int final_cost;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		nV = Integer.parseInt(st.nextToken());
		nE = Integer.parseInt(st.nextToken());
		
		// �������� �̾��� ��� �ΰ��� weight �Ѱ� ����
		graph = new int[nE][3];
		
		for (int i=0; i<nE; i++) {
			st = new StringTokenizer(br.readLine());
			graph[i][0] = Integer.parseInt(st.nextToken());
			graph[i][1] = Integer.parseInt(st.nextToken());
			graph[i][2] = Integer.parseInt(st.nextToken());
		}
		
		parent = new int[nV];
		final_cost= 0;
		
		// ����ġ�� ������ �ؾ��ϱ� ������ ������ o1[2], o2[2]�� ����
		Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));
		
		// makeSet
		for (int i=0; i<nV; i++) {
			parent[i] = i;
		}
		
		
		for(int i=0; i<nE; i++) {
			if(find(graph[i][0] - 1) != find(graph[i][1] -1 )) {
				System.out.println("���õ� ����");
				System.out.println(graph[i][0] + ", " +graph[i][1]);
				union(graph[i][0] -1, graph[i][1] -1);
				final_cost += graph[i][2];
			}
		}
		System.out.println("�� ����� root ���");
		System.out.println(Arrays.toString(parent) +"\n");
		System.out.println("���� ���: " + final_cost);
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
