package 삼성기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 낚시왕 {
	static class shark {
		int s, d, z;

		shark(int s, int d, int z) {
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

	static shark[][] map;
	static long answer = 0;
	static int R, C;
	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new shark[R + 1][C + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			shark sh = new shark(s, d, z);
			map[r][c] = sh;
		}

		for (int i = 1; i <= C; i++) {
			// 낚시 시작
			// 땅에서 가장 가까운 상어 찾기
			capture(i);
			// 상어 이동
			move_shark();
		}
		System.out.println(answer);
	}

	public static void capture(int start) {
		for (int i = 1; i <= R; i++) {
			if (map[i][start] != null) {
				answer += (long) map[i][start].z;
				map[i][start] = null;
				return;
			}
		}
	}

	public static void move_shark() {
		shark[][] temp = new shark[R + 1][C + 1];
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (map[i][j] != null) {
					// 일단 벽까지 이동
					int dir = map[i][j].d;
					int size = map[i][j].s;
					int nx = i;
					int ny = j;
					// 각 가는 방향으로 갈 수 있을 때까지
					boolean flag = false;
					while (size > 0) {
						nx += dx[dir];
						ny += dy[dir];
						size--;
						if (dir == 1 && nx == 0) {
							dir = 2;
							nx = 1;
							flag = true;
						} else if (dir == 2 && nx == R + 1) {
							dir = 1;
							nx = R;
							flag = true;
						} else if (dir == 3 && ny == C + 1) {
							dir = 4;
							ny = C;
							flag = true;
						} else if (dir == 4 && ny == 0) {
							dir = 3;
							ny = 1;
							flag = true;
						}
						if (flag) {
							size++;
							break;
						}
					}
					if (size > 0) {
						if (dir <= 2) {
							int mok = size / (R - 1);
							int nmg = size % (R - 1);
							if (dir == 1) {
								if (mok % 2 == 0) {
									nx -= nmg;
								} else {
									dir = 2;
									nx = nmg + 1;
								}
							} else {
								if (mok % 2 == 0) {
									nx += nmg;
								} else {
									dir = 1;
									nx = R - nmg;
								}
							}

						} else {
							int mok = size / (C - 1);
							int nmg = size % (C - 1);
							if (dir == 3) {
								if (mok % 2 == 0) {
									ny += nmg;
								} else {
									dir = 4;
									ny = C - nmg;
								}
							} else {
								if (mok % 2 == 0) {
									ny -= nmg;
								} else {
									dir = 3;
									ny = nmg + 1;
								}
							}
						}
					}
					shark newShark = new shark(map[i][j].s, dir, map[i][j].z);
					if (temp[nx][ny] != null) {
						if (temp[nx][ny].z < newShark.z) {
							temp[nx][ny] = newShark;
						}
					} else {
						temp[nx][ny] = newShark;
					}
				}
			}
		}

		map = temp.clone();
	}
}
