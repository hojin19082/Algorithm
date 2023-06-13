import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	static class Point{
		int x, y, count;
		Point(int x, int y, int count){
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int startX = 0;
		int startY = 0;
		int[][] map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					startX = i;
					startY = j;
				}
			}
		}
		int[][] result = bfs(startX,startY,map);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(result[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}public static int[][] bfs(int x, int y, int[][] map) {
		Queue<Point> q = new LinkedList<>();
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		boolean[][] visited = new boolean[map.length][map[0].length];
		visited[x][y] = true;
		q.offer(new Point(x, y, 0));
		int[][] temp = new int[map.length][map[0].length];
		
		for(int i=0; i<temp.length; i++) {
			temp[i] = Arrays.copyOf(map[i], map[0].length);
		}
		temp[x][y] = 0;
		while(!q.isEmpty()) {
			Point now = q.poll();
			for(int i=0; i<4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if(nx<0||ny<0||nx>=map.length||ny>=map[0].length||visited[nx][ny]||map[nx][ny] == 0) {
					continue;
				}
				visited[nx][ny] = true;
				temp[nx][ny] = now.count+1;
				q.offer(new Point(nx,ny,now.count+1));
			}
		}
		
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				if(temp[i][j] == 1 && !visited[i][j]) temp[i][j] = -1;
			}
		}
		return temp;
	}

}
