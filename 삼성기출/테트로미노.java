import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
public class 테트로미노 {
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	static int max = Integer.MIN_VALUE;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				visited[i][j] = true;
				dfs(i,j, map[i][j], 1);
				visited[i][j] = false;
			}
		}
	
		System.out.println(max);
	}
	public static void dfs(int x, int y, int sum, int count) {
		if(count == 4) {
			max = Math.max(max, sum);
			return;
		}
	
		for(int i=0; i<4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
	
			if(cx < 0 || cx >= N || cy < 0 || cy >= M) {
				continue;
			}
	
			if(!visited[cx][cy]) {
				if(count == 2) {
					visited[cx][cy] = true;
					dfs(x,y,sum+map[cx][cy], count+1);
					visited[cx][cy] = false;
				}
	
				visited[cx][cy] = true;
				dfs(cx,cy,sum+map[cx][cy], count+1);
				visited[cx][cy] = false;
			}
		}
	}
}