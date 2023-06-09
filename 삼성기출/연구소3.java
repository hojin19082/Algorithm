import java.io.*;
import java.util.*;
import java.awt.Point;

public class 연구소3 {
	// 바이러스를 M개만큼 뽑아서 bfs돌린 후 최소 값을 뽑으면 됨
	// dfs + bfs
	static class Point {
		int x, y, time;

		Point(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	static int N, M;
	static List<Point> virus = new ArrayList<>();
	static int[][] map;
	static int answer = Integer.MAX_VALUE;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean complete = false;
	static int zeroCount = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					zeroCount++;
				if (map[i][j] == 2) {
					virus.add(new Point(i, j, 0));
				}
			}
		}
		if (zeroCount != 0) {
			dfs(0, new ArrayList<>());
			System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
		} else {
			System.out.println(0);
		}
	}

	public static void dfs(int start, List<Point> selectVirus) {
		if (selectVirus.size() == M) {
			bfs(selectVirus);
			return;
		}
		for (int i = start; i < virus.size(); i++) {
			selectVirus.add(virus.get(i));
			dfs(i + 1, selectVirus);
			selectVirus.remove(selectVirus.size() - 1);
		}
	}

	public static void bfs(List<Point> selectVirus) {
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		for (Point p : selectVirus) {
			visited[p.x][p.y] = true;
			// 활성화된 바이러스는 0으로
			q.offer(p);
		}
		int tempZero = zeroCount;
		while (!q.isEmpty()) {
			Point now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || map[nx][ny] == 1) {
					continue;
				}
				if(map[nx][ny] ==0) tempZero--;
				if(tempZero == 0) {
					answer = Math.min(answer,now.time + 1);
					return;
				}
				visited[nx][ny] = true;
				q.offer(new Point(nx, ny, now.time + 1));
			}
		}
	}
}
