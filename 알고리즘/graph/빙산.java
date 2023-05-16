import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class 빙산 {
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int answer = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		deleteIce();
		System.out.println(answer);
	}
	public static void deleteIce() {
		int year = 0;
		while(true) {
			boolean[][] visited =new boolean[map.length][map[0].length];
			int count = 0;
			for(int i=0; i<map.length; i++) {
				for(int j=0; j<map[i].length; j++) {
					if(!visited[i][j] && map[i][j] > 0) {
						dfs(visited, i, j);
						count++;
					}
				}
			}
			if(count == 0 ) break;
			if(count >= 2 ) {
				answer = year;
				break;
			}
			
			int[][] temp = new int[map.length][map[0].length];
			for(int i=0; i<map.length; i++) {
				temp[i] = Arrays.copyOf(map[i], map[i].length);
			}
			for(int i=0; i<map.length; i++) {
				for(int j=0; j<map[i].length; j++) {
					if(temp[i][j] > 0) {
						int cnt = 0;
						for(int t=0; t<4; t++) {
							int nx = i+dx[t];
							int ny = j+dy[t];
							if(nx < 0 || ny <0 || nx > map.length || ny>map[0].length) continue;
							if(map[nx][ny] <= 0) cnt++;
						}
						temp[i][j] -= cnt;
					}
				}
			}
			map = temp;
			year++;
		}
	}
	public static void dfs(boolean[][] visited, int x, int y) {
		visited[x][y] = true;
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(visited[nx][ny] || nx < 0 || ny <0 || nx > map.length || ny>map[0].length) continue;
			if(map[nx][ny] > 0) {
				dfs(visited, nx, ny);
			}
		}
	}
}
