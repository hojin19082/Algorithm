package graph;

import java.io.*;
import java.util.*;
public class ¼û¹Ù²ÀÁú3 {
	static int answer = Integer.MAX_VALUE;
	static class Point{
		int n, count;
		Point(int n, int count){
			this.n = n;
			this.count = count;
		}
	}
	static int N, K;
	static boolean[] visited = new boolean[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bfs(N);
		System.out.println(answer);
	}
	public static void bfs(int start) {
		visited[start] = true;
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(start, 0));
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(p.n == K) {
				answer = Math.min(answer, p.count);
			}
			
			if(p.n * 2 <= 100000 && !visited[p.n*2] ) {
				visited[p.n*2] = true;
				q.offer(new Point(p.n*2, p.count));
			}
			
			if(p.n-1 >= 0 && !visited[p.n-1]) {
				visited[p.n-1] = true;
				q.offer(new Point(p.n-1, p.count+1));
			}
			
			if(p.n+1 <= 100000 && !visited[p.n+1]) {
				visited[p.n+1] = true;
				q.offer(new Point(p.n+1, p.count+1));
			}
			
			
		}
	}
}
