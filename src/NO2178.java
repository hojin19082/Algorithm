import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class NO2178 {
	static int n,m;
	static int [][] maze;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
    
		maze = new int[n][m];
		visited = new boolean[n][m];
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				maze[i][j] = str.charAt(j) - '0';
				visited[i][j] = false;
			}
		}
		visited[0][0] = true;
		bfsMaze(0,0);
		System.out.println(maze[n-1][m-1]);
	}
	private static void bfsMaze(int x, int y) {
		
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(x, y));
		while(!q.isEmpty()) {
			Dot d = q.poll();
			//상, 하, 좌, 우 순으로 다음 갈 칸을 정하고
			for(int i=0; i<4; i++) {
				int nextX = d.x + dx[i];
				int nextY = d.y + dy[i];
				
				//다음 좌표가 범위를 넘어갈때 건너뛰기
                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
                    continue;
                }
                //이미 방문하거나 갈 수 없는 길이면 건너뛰기
                if (visited[nextX][nextY] || maze[nextX][nextY] == 0) {
                    continue;
                }
                // 갈 수 있으면 큐에 추가하고
                // 이전 칸의 값에서 1 추가하여 지금까지 간 칸 수를 저장
                q.add(new Dot(nextX, nextY));
                maze[nextX][nextY] = maze[d.x][d.y] + 1;
                // 간 곳은 방문했다고 true
                visited[nextX][nextY] = true;
			}
		}

	}
}
class Dot{
	int x;
	int y;
	Dot(int x, int y){
		this.x = x;
		this.y = y;
	}
}
