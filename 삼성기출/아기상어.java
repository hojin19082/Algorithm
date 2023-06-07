package 삼성기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 아기상어 {
	static int sharkX, sharkY, sharkEat, sharkSize;
	static int fishCount = 0, time=0;
	static int N;
	static int[][] map;
	//상, 좌, 우, 하
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	static class Shark implements Comparable<Shark>{
		int x,y,count;
		Shark(int x, int y, int count){
			this.x = x;
			this.y = y;
			this.count = count;
		}
		@Override
		//count가 최우선으로 고려되야하고 만약 같으면x, y좌표 순으로 큐에서 정렬되도록 해주기!
		public int compareTo(Shark s) {
			if(this.count == s.count) {
				if(this.x == s.x) {
					return this.y - s.y;
				}
				return this.x - s.x;
			}
			return this.count - s.count;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					sharkX = i;
					sharkY = j;
					map[i][j] = 0;
				}else if(map[i][j] > 0) {
					fishCount++;
				}
			}
		}
		if(fishCount == 0) {
			System.out.println(0);
		}else {
			sharkSize = 2;
			sharkEat = 0;
			//물고기 개수가 0이 될때까지
			while(fishCount!=0) {
				//물고기 한마리면 그 물고기 위치까지 이동
				int prevCount = fishCount;
				findFish();
				if(prevCount == fishCount) {
					break;
				}	
			}
			System.out.println(time);
		}
	}
	public static void findFish() {
		PriorityQueue<Shark> q = new PriorityQueue<>();
		q.offer(new Shark(sharkX, sharkY, 0));
		boolean[][] visited = new boolean[N][N];
		visited[sharkX][sharkY] = true;
		//갈 수 있는 좌표들을 우선순위 큐에 넣어주면
		//그 다음엔 count, x, y좌표 순으로 오름차순 정렬된 상태로 가장 먼저 우선순위가 높은 shark 뽑아서 진행
		while(!q.isEmpty()) {
			Shark now = q.poll();
			if(map[now.x][now.y] > 0 && map[now.x][now.y] < sharkSize) {
				sharkX = now.x;
				sharkY = now.y;
				sharkEat++;
				if(sharkEat == sharkSize) {
					sharkSize++;
					sharkEat = 0;
				}
				map[sharkX][sharkY] = 0;
				fishCount--;
				time += now.count;
				return;
			}
			for(int i=0; i<4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || map[nx][ny] > sharkSize) continue;
				visited[nx][ny] = true;
				q.offer(new Shark(nx, ny, now.count+1));
			}
		}	
	}

}
