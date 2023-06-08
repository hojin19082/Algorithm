package 삼성기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 어른상어 {
	static class sharkSmell {
		int num, k;

		sharkSmell(int num, int k) {
			this.num = num;
			this.k = k;
		}
	}

	static class Shark {
		int x, y, dir;
		int[][] priority;

		Shark(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.priority = new int[5][5];
		}

		public void dirSet(int dir) {
			this.dir = dir;
		}

		public void prioritySet(int[][] priority) {
			this.priority = priority;
		}
	}

	static int N, M, K;
	static int[][] map;
	static sharkSmell[][] smell;
	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, -1, 1 };
	static TreeMap<Integer, Shark> sharkMap = new TreeMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		smell = new sharkSmell[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0) {
					sharkMap.put(map[i][j], new Shark(i, j, 0));
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		for (Integer num : sharkMap.keySet()) {
			Shark s = sharkMap.get(num);
			s.dirSet(Integer.parseInt(st.nextToken()));
		}

		for (Integer num : sharkMap.keySet()) {
			Shark s = sharkMap.get(num);
			int[][] priority = new int[5][5];
			for (int i = 1; i <= 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= 4; j++) {
					priority[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			s.prioritySet(priority);
		}

		// 상어 이동 시작
		int time = 0;
		while (time <= 1000) {
			if (sharkMap.size() == 1) {
				break;
			}
			smellCheck();
			sharkMove();
			time++;
		}
		if (time == 1001) {
			System.out.println(-1);
		} else {
			System.out.println(time);
		}
	}

	public static void smellCheck() {
		for (Integer num : sharkMap.keySet()) {
			Shark shark = sharkMap.get(num);
			// 기존 자리에 냄새 생성
			sharkSmell smellshark = new sharkSmell(num, K);
			smell[shark.x][shark.y] = smellshark;
		}
	}

	public static void sharkMove() {
		TreeMap<Integer, Shark > temp = (TreeMap<Integer, Shark>) sharkMap.clone();
		for (Integer i : temp.keySet()) {
			if (sharkMap.containsKey(i)) {
				Shark shark = sharkMap.get(i);
				if(map[shark.x][shark.y] == i) {
					map[shark.x][shark.y] = 0;	
				}
				
				int sharkDir = shark.dir;
				int[] priorityDir = shark.priority[sharkDir];
				int count = 0;
				for (int d = 1; d <= 4; d++) {
					int nx = shark.x + dx[priorityDir[d]];
					int ny = shark.y + dy[priorityDir[d]];
					// 만약 냄새가 있거나 외각이면 다음 dir로
					if (nx < 1 || ny < 1 || nx > N || ny > N || smell[nx][ny] != null) {
						count++;
						continue;
					}
					if (map[nx][ny] != 0 && map[nx][ny] < i) {
						sharkMap.remove(i);
						break;
					}
					map[nx][ny] = i;
					shark.dirSet(priorityDir[d]);
					shark.x = nx;
					shark.y = ny;
					sharkMap.put(i, shark);
					break;
				}
				// 갈 수 없으면
				if (count == 4) {
					// 주변의 자신의 냄새를 찾아야함 (반시계로 90도)
					for (int d = 1; d <= 4; d++) {
						int nx = shark.x + dx[priorityDir[d]];
						int ny = shark.y + dy[priorityDir[d]];
						if (nx < 1 || ny < 1 || nx > N || ny > N) {
							continue;
						}
						if (smell[nx][ny].num == i) {
							shark.dirSet(priorityDir[d]);
							shark.x = nx;
							shark.y = ny;
							sharkMap.put(i, shark);
							map[shark.x][shark.y] = i;
							break;
						}
					}
				}
			}
		}

		for (int t = 1; t <= N; t++) {
			for (int j = 1; j <= N; j++) {
				if (smell[t][j] != null) {
					if (smell[t][j].k > 1) {
						smell[t][j].k--;
					} else if (smell[t][j].k == 1) {
						smell[t][j] = null;
					}
				}
			}
		}
	}
}
