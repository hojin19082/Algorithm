package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NO2468 {
	private static int count;
	private static int N;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		visited = new boolean[N+1][N+1];
		int max = 0;
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(max < map[i][j]) {
					max = map[i][j];
				}
			}
		}
		int height = 1;
		int safe = 0;
		while(height < max) {
			count = 0;
			for(int i=1;i<N+1; i++) {
				for(int j=1; j<N+1; j++) {
					if(map[i][j] > height && visited[i][j] == false) {
						dfs(i,j, height);
						count++;
					}
				}
			}
			
			for(int i=1;i<N+1; i++) {
				for(int j=1; j<N+1; j++) {
					if(visited[i][j] == true) {
						visited[i][j] = false;
					}
				}
			}
			
			height++;
			if(safe < count) {
				safe = count;
			}
		}
		System.out.println(safe);
	}
	public static void dfs(int start, int end, int height) {
		visited[start][end] = true;
		for (int i=0; i<4; i++) {
			int cx = start + dx[i];
			int cy = end + dy[i];
			if(cx > 0 && cy>0 && cx<N+1 && cy<N+1) {
				if(map[cx][cy] > height && visited[cx][cy] == false) {
					dfs(cx, cy, height);
				}
			}
		}
	}
}
