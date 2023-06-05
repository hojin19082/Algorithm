package 삼성기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 새로운게임2 {
	static int N, K;
	static int[][] map;

	static class mal {
		int x, y, d, seq;

		mal(int x, int y, int d, int seq) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.seq = seq;
		}
	}

	static List<mal>[][] count;
	static int[] dx = { 0, 0, 0, -1, 1 };
	static int[] dy = { 0, 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		count = new ArrayList[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				count[i][j] = new ArrayList<>();
			}
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		PriorityQueue<mal> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.seq));
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			mal m = new mal(x, y, d, i + 1);
			count[x][y].add(m);
			pq.add(m);
		}

		int answer = 1;
		while (answer <= 1000) {
			// 게임시작
			boolean flag = false;
			List<mal> temp = new ArrayList<>();
			int length = pq.size();
			for (int i = 0; i < length; i++) {
				mal m = pq.poll();
				List<mal> list = count[m.x][m.y];
				int index = 0;
				for (int t = 0; t < list.size(); t++) {
					if (m.seq == list.get(t).seq) {
						index = t;
						break;
					}
				}
				List<mal> upper = new ArrayList<>();
				for (int t = index; t < list.size(); t++) {
					upper.add(list.get(t));

				}
				//이동하기 전 위치에서 index부터 원소들 제거
				int ll = count[m.x][m.y].size();
				for (int t = index; t < ll; t++) {
					count[m.x][m.y].remove(index);
				}
				//이동 시작
				int dir = m.d;
				int nx = m.x + dx[dir];
				int ny = m.y + dy[dir];
				// 벽일 경우 (벽만나서 반대로 갈때도 빨,파,흰 조건 만족해야함)
				//오른쪽 벽일 경우
				if (dir == 1 && ny == N + 1) {
					dir = 2;
					ny = N - 1;
					if (map[nx][ny] == 2) {
						ny = N;
						count[nx][ny].addAll(upper);
					}else if(map[nx][ny] == 1) {
						for (int j = upper.size() - 1; j >= 0; j--) {
							count[nx][ny].add(upper.get(j));
						}
					}else {
						count[nx][ny].addAll(upper);
					}
					//왼쪽 벽일 경우
				} else if (dir == 2 && ny == 0) {
					dir = 1;
					ny = 2;
					if (map[nx][ny] == 2) {
						ny = 1;
						count[nx][ny].addAll(upper);
					}else if(map[nx][ny] == 1) {
						for (int j = upper.size() - 1; j >= 0; j--) {
							count[nx][ny].add(upper.get(j));
						}
					}else {
						count[nx][ny].addAll(upper);
					}
					//위쪽 벽일 경우
				} else if (dir == 3 && nx == 0) {
					dir = 4;
					nx = 2;
					if (map[nx][ny] == 2) {
						nx = 1;
						count[nx][ny].addAll(upper);
					}else if(map[nx][ny] == 1) {
						for (int j = upper.size() - 1; j >= 0; j--) {
							count[nx][ny].add(upper.get(j));
						}
					}else {
						count[nx][ny].addAll(upper);
					}
					//아래쪽 벽일 경우
				} else if (dir == 4 && nx == N + 1) {
					dir = 3;
					nx = N - 1;
					if (map[nx][ny] == 2) {
						nx = N;
						count[nx][ny].addAll(upper);
					}else if(map[nx][ny] == 1) {
						for (int j = upper.size() - 1; j >= 0; j--) {
							count[nx][ny].add(upper.get(j));
						}
					}else {
						count[nx][ny].addAll(upper);
					}
				} else {
					// 벽이 아닐 경우
					if (map[nx][ny] == 0) {
						// 흰색
						count[nx][ny].addAll(upper);
					} else if (map[nx][ny] == 1) {
						// 빨
						// 뒤집기
						for (int j = upper.size() - 1; j >= 0; j--) {
							count[nx][ny].add(upper.get(j));
						}

					} else {
						// 파란
						nx -= dx[dir];
						ny -= dy[dir];
						if (dir == 1)
							dir = 2;
						else if (dir == 2)
							dir = 1;
						else if (dir == 3)
							dir = 4;
						else
							dir = 3;
						if (nx + dx[dir] > 0 && ny + dy[dir] > 0 && nx + dx[dir] < N + 1 && ny + dy[dir] < N + 1
								&& map[nx + dx[dir]][ny + dy[dir]] != 2) {
							nx += dx[dir];
							ny += dy[dir];
							//이동한 뒤에도 흰, 빨 경우 생각
							if (map[nx][ny] == 1) {
								for (int j = upper.size() - 1; j >= 0; j--) {
									count[nx][ny].add(upper.get(j));
								}
							}else if(map[nx][ny] == 0) {
								count[nx][ny].addAll(upper);
							}
						}else {
							//이전에 지웠기 때문에 다시 채워줘야 함.
							count[nx][ny].addAll(upper);
						}
					}
				}
				//4개 이상이면 바로 끝
				if (count[nx][ny].size() >= 4) {
					flag = true;
					break;
				}

				// 같이 움직인 애들의 x,y좌표 변경
				// 현재 순서와 같은 애는 dir도 변경
				for (int t = 0; t < count[nx][ny].size(); t++) {
					count[nx][ny].get(t).x = nx;
					count[nx][ny].get(t).y = ny;
					if (m.seq == count[nx][ny].get(t).seq) {
						count[nx][ny].get(t).d = dir;
					}
				}

			}
			if (flag)
				break;
			//우선순위 큐에 다시 말 개수만큼 넣어주기
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (count[i][j].size() > 0) {
						for (mal mm : count[i][j]) {
							pq.offer(mm);
						}
					}
				}
			}
			answer++;
		}

		if (answer == 1001) {
			System.out.println(-1);
		} else
			System.out.println(answer);
	}
}
