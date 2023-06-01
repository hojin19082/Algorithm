package 구현;

import java.util.*;
import java.io.*;
import java.awt.Point;

public class 미세먼지안녕 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int upCleanerX;
	static int downCleanerX;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		int cleanerCount = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					if (cleanerCount == 0) {
						upCleanerX = i;
						cleanerCount++;
					} else {
						downCleanerX = i;
					}
				}
			}
		}
		for (int tc = 0; tc < T; tc++) {
			// 미세먼지 확산
			int[][] temp = spreadDust(map);
			// 공기청정기 작동
			map = temp.clone();
			workCleaner(map);
		}
		System.out.println(cal(map));
	}
	
	//남은 미세먼지 계산
	public static int cal (int[][] map) {
		int count = 0;
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				if(map[i][j] > 0) {
					count+=map[i][j];
				}
			}
		}
		return count;
	}
	
	public static void workCleaner(int[][] map) {
		
		int r = map.length;
		int c = map[0].length;
		int[][] temp = new int[r][c];
		for (int i = 0; i < r; i++) {
			temp[i] = Arrays.copyOf(map[i], c);
		}
		// 위쪽 공기청정기 시작
		// 오른쪽으로
		int upY = 1;
		int upX = upCleanerX;
		map[upX][upY] = 0;
		while (upY < c-1) {
			map[upX][upY + 1] = temp[upX][upY];
			upY++;
		}
		// 위쪽으로
		while (upX > 0) {
			map[upX - 1][c-1] = temp[upX][c-1];
			upX--;
		}
		// 왼쪽으로
		upY = c-1;
		while (upY > 0) {
			if(upCleanerX == 0 && upY-1 == 0) {
				break;
			}
			map[upX][upY - 1] = temp[upX][upY];
			upY--;
		}
		// 아래로
		upX = 0;
		while (upX != upCleanerX) {
			if(map[upX+1][0] == -1) break;
			map[upX + 1][0] = temp[upX][0];
			upX++;
		}

		//아래쪽 공기청정기 시작
		int downY = 1;
		int downX = downCleanerX;
		// 오른쪽으로
		map[downX][downY] = 0;
		while (downY< c-1) {
			map[downX][downY + 1] = temp[downX][downY];
			downY++;
		}
		
		// 아래로
		while (downX< r-1) {
			map[downX + 1][downY] = temp[downX][downY];
			downX++;
		}
		// 왼쪽으로
		downY = c-1;
		while (downY > 0) {
			if(downCleanerX == r-1 && downY - 1 == 0) {
				break;
			}
			map[downX][downY - 1] = temp[downX][downY];
			downY--;
		}
		downX = r-1;
		// 위로
		while (downX!= downCleanerX) {
			if(map[downX-1][0] == -1) break;
			map[downX - 1][0] = temp[downX][0];
			downX--;
		}
	}

	public static int[][] spreadDust(int[][] map) {
		int r = map.length;
		int c = map[0].length;
		int[][] temp = new int[r][c];
		for (int i = 0; i < r; i++) {
			temp[i] = Arrays.copyOf(map[i], c);
		}
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] >= 5) {
					// 4방향으로 갈 수 있는 개수 찾고
					int count = 0;
					List<Point> list = new ArrayList<>();
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if (nx < 0 || ny < 0 || nx >= r || ny >= c || (nx == upCleanerX && ny == 0)
								|| (nx == downCleanerX && ny == 0))
							continue;
						count++;
						// 갈 수 있는 곳의 칸 저장
						list.add(new Point(nx, ny));
					}
					// 확산시작
					int spread = map[i][j] / 5;
					temp[i][j] -= spread * count;
					for (Point p : list) {
						temp[p.x][p.y] += spread;
					}
				}
			}
		}
		return temp;
		
	}

}
