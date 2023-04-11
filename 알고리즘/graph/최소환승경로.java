package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

import java.util.*;
public class 최소환승경로 {
	static int N, L;
	static ArrayList<Integer>[] train;
	static ArrayList<Integer>[] lines;
	static boolean[] visited;
	static boolean[] visitedLine;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		train = new ArrayList[N+1];
		visited = new boolean[N+1];
		visitedLine = new boolean[N+1];
		lines = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			train[i] = new ArrayList<>();
			lines[i] = new ArrayList<>();
		}
		
		for(int i=1; i<=L; i++) {
			String[] str = br.readLine().split(" ");
			for(int j=0; j<str.length; j++) {
				int station = Integer.parseInt(str[j]);
				if(station == -1) break;
				train[station].add(i);
				lines[i].add(station);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int answer = bfs(start,end);
		System.out.println(answer);
		
	}public static int bfs(int start, int end) {
		PriorityQueue<Edge> q = new PriorityQueue<>(Comparator.comparingInt(n -> n.change));
		visited[start] = true;
		for(int line: train[start]) {
			q.offer(new Edge(line, start, 0));
			visitedLine[line] = true;
		}
		while(!q.isEmpty()) {
			Edge now = q.poll();
			if(now.to == end) {
				return now.change;
			}
			for(int next: lines[now.line]) {
				
				if(visited[next]) continue;
				else {
					visited[next] = true;
					q.offer(new Edge(now.line,next,now.change));
					
					for(int nextLine : train[next]) {
						if(!visitedLine[nextLine]) {
							visitedLine[nextLine] =true;
							q.offer(new Edge(nextLine, next, now.change+1));
						}
					}
				}
			}
		}
		return -1;
	}
}class Edge{
	int line,to,change;
	Edge(int line, int to, int change){
		this.to = to;
		this.line = line;
		this.change = change;
	}

}
