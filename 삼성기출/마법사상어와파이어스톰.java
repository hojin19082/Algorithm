
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
import java.awt.Point;

public class 마법사상어와파이어스톰 {
	static int[][] map;
	static int[] play;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int size = 0;
	static boolean[][] visited;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		size = (int) Math.pow(2, n);

		map = new int[size + 1][size + 1];
		visited = new boolean[size + 1][size + 1];
		play = new int[q];

		for (int i = 1; i <= size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		if (q == 1) {
			play[0] = Integer.parseInt(br.readLine());
		} else {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < q; i++) {
				play[i] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < q; i++) {
			map = divide(play[i]);

			for (int j = 1; j <= size; j++) {
				for (int t = 1; t <= size; t++) {
					if(map[j][t] == 0) continue;
					if (ice_count(j, t) < 3) {
						map[j][t]--;
					}
				}
			}
		}

		int sum = 0;
		for (int j = 1; j <= size; j++) {
			for (int t = 1; t <= size; t++) {
				if (map[j][t] > 0) {
					sum += map[j][t];
					if (!visited[j][t]) {
						bfs(j, t);
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(sum).append('\n').append(max);

		System.out.println(sb);
	}

	public static int[][] divide(int Size) {
		int[][] tmp = new int[size + 1][size + 1];
		Size = (int) Math.pow(2, Size);
		// 90도 회전

		for (int j = 1; j <= size; j += Size) {
			for (int t = 1; t <= size; t += Size) {
				rotate(j, t, Size, tmp);
			}
		}

		return tmp;
	}

	public static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		visited[x][y] = true;
		q.offer(new Point(x, y));
		int count = 1;
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (nx < 1 || nx > size || ny < 1 || ny > size || visited[nx][ny])
					continue;
				if (map[nx][ny] > 0) {
					visited[nx][ny] = true;
					count++;
					q.offer(new Point(nx, ny));
				}
			}
		}
		max = Math.max(max, count);
	}

	public static void rotate(int a, int b, int subSize, int[][] tmp) {
		for (int i = 0; i < subSize; i++) {
			for (int j = 0; j < subSize; j++) {
				tmp[a + i][b + j] = map[a + subSize - 1 - j][b + i];
			}
		}
	}

	public static int ice_count(int x, int y) {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 1 || nx > size || ny < 1 || ny > size)
				continue;
			if (map[nx][ny] > 0) {
				count++;
			}
		}
		return count;
	}

}
