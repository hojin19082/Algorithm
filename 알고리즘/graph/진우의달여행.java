package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 진우의달여행 {

	static int N, M;
	static int[][] map;
	static int[] dx = {1, 1, 1};
	static int[] dy = {-1,0,1};
	static int answer = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		System.out.println(answer);
	}
	public static void bfs() {
		PriorityQueue<rocket> pq = new PriorityQueue<>(Comparator.comparingInt(n->n.sum));
		
		for(int i=0; i<M; i++) {
			pq.offer(new rocket(0,i,map[0][i],-1));
		}
		
		while(!pq.isEmpty()) {
			rocket now = pq.poll();
			for(int i=0; i<3; i++) {
				if(now.dir == i) continue;
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if(ny<0 || ny>=M) continue;
				
				if(nx == N) {
					answer = now.sum;
					return;
				}
				
				pq.offer(new rocket(nx,ny, now.sum + map[nx][ny], i));
			}
		}
	}
}
class rocket{
	int x,y,sum, dir;
	rocket(int x, int y, int sum, int dir){
		this.x = x;
		this.y = y;
		this.sum = sum;
		this.dir = dir;
	}
}