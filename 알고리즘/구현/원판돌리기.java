package 구현;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class 원판돌리기 {
	static int[][] one;
	static int N, M, T;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int answer = 0;
	static boolean isDup;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		one = new int[N + 1][M + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				one[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			// work[i][0]은 원판 , [1]은 방향, [2]는 칸 수
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			isDup = false;
			for (int t = x; t <= N; t += x) {
				int[] temp = new int[M+1];
				temp = one[t].clone();
				// 반시계
				if (d == 1) {
					for (int j = 1; j <= M; j++) {
						if (j + k <= M) {
							one[t][j] = temp[j + k];
						} else {
							one[t][j] = temp[j + k - M];
						}
					}
				} else {
					// 시계	
					for (int j = 1; j <= M; j++) {
						if (j - k > 0) {
							one[t][j] = temp[j - k];
						} else {
							one[t][j] = temp[M + j - k];
						}
					}
				}
			}
			
			int cnt = 0;
			for(int j=1;j<=N;j++) {
				for(int a=1;a<=M;a++) {
					if(one[j][a] != 0) {
						cnt += bfs(j, a, one[j][a]);
					}
				}
			}

			int sum = 0;
			int count = 0;
			
			if (cnt == 0){
				for (int j = 1; j <= N; j++) {
					for (int t = 1; t <= M; t++) {
						if (one[j][t] != 0) {
							count++;
							sum += one[j][t];
						}
					}
				}
				double avg = (double) sum /  (double) count;
				
				for (int j = 1; j <= N; j++) {
					for (int t = 1; t <= M; t++) {
						if(one[j][t] == 0) continue;
						if (one[j][t] > avg) {
							one[j][t]--;
						}else if(one[j][t] < avg){
							one[j][t]++;
						}
					}
				}
			}
			
			
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if(one[i][j] == 0) continue;
				answer += one[i][j];
			}
		}
		System.out.println(answer);

	}

	public static int bfs(int x, int y, int num) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y));
		int cnt = 0;
		while (!q.isEmpty()) {
			Node n = q.poll();

			for (int i = 0; i < 4; i++) {
				int cx = n.x + dx[i];
				int cy = n.y + dy[i];
				if(cx < 1 || cx > N) {
					continue;
				}
				if(cy < 1 || cy > M) {
					cy = (cy==0?M:1);
				}
				
				if(one[cx][cy] != 0 && one[cx][cy] == num) {
					one[cx][cy] = 0;
					cnt++;
					q.add(new Node(cx, cy));
				}

			}
		}
		if(cnt == 0) {
			one[x][y] = num;
		}
		return cnt;
	}
}

class Node {
	int x;
	int y;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
