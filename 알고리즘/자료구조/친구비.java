package 자료구조;
import java.util.*;
import java.io.*;

public class 친구비 {
	static int N,M,K;
	static List<Integer>[] arr;
	static boolean[] visited;
	static int[] cost;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		cost = new int[N+1];
		visited = new boolean[N+1];
		st = new StringTokenizer(br.readLine());
		arr = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) {
			arr[i] = new ArrayList<>();
			cost[i] =Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		long sum = 0;
		for(int i=1; i<N+1; i++) {
			if(!visited[i]) {
				sum += dfs(i, cost[i]);
			}
		}
		if(sum > K) System.out.println("Oh no");
		else System.out.println(sum);
	}
	public static int dfs(int start, int value) {
		visited[start] = true;
		for(int v : arr[start]) {
			if(visited[v]) continue;
			value = dfs(v, Math.min(value, cost[v]));
		}
		return value;
	}

}
