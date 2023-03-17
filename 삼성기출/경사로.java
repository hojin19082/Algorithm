package 삼성기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경사로 {
	static int N, L;
	static int[][] map;
	// 오 아
	static int[] dx = { 0, 1 };
	static int[] dy = { 1, 0 };
	static int answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i == 0) {
					dfs(0,j,1,1,0,1);
				}
				
				if(j==0) {
					dfs(i,0,1,1,0,0);
				}
				
			}
		}
		
		System.out.println(answer);
		
	}

	public static void dfs(int x, int y, int count, int cur, int rudtk, int dir) {
		
		if(count == N) {
			answer++;
			return;
		}
			int cx = x + dx[dir];
			int cy = y + dy[dir];
			if(cx >= N || cy >=N ) return;
			
			if(map[cx][cy] == map[x][y]) {
				dfs(cx,cy, count+1, cur+1, 0, dir);
			}
			//다음 값이 현재 값보다 1클 경우
			else if(map[cx][cy] - map[x][y] == 1) {
				//연속으로 올 경우 경사로를 없애야 하는데 어떻게?
				if(cur-L*rudtk>=L) {
					dfs(cx,cy,count+1,1,0, dir);
				}
				//다음 값이 현재 값보다 1 작을 경우
			}else if(map[x][y] - map[cx][cy] == 1) {
				int cnt = 1;
				int nx = cx;
				if(rudtk>0) rudtk--;
				int ny = cy;
				while(true) {
					nx += dx[dir];
					ny += dy[dir];

					if(nx >= N || ny >= N || map[nx][ny] != map[cx][cy]) {
						nx-=dx[dir];
						ny-=dy[dir];
						break;
					}
					cnt++;
				}
				
				if(cnt >= L) {
					dfs(nx,ny,count+cnt ,cnt, rudtk+1, dir);
				}
			}
			
		}
	
}
