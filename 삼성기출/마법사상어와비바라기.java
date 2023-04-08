

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
public class 마법사상어와비바라기 {
	static int[][] map;
	static int[][] cloud;
	//구름 8방향 이동
	static int[] dx = {0,0,-1,-1,-1,0,1,1,1};
	static int[] dy = {0,-1,-1,0,1,1,1,0,-1};
	static int N;
	static Queue<Point> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		cloud = new int[N+1][N+1];
		for(int i=1; i<N+1; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				cloud[i][j] = 0;
			}
		}
		
		q.offer(new Point(N,1));
		q.offer(new Point(N-1, 1));
		q.offer(new Point(N, 2));
		q.offer(new Point(N-1, 2));
		
		for(int i=0; i<M; i++) {
			st= new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			cloud_move(d, s);
			water_copy();
			new_cloud();
		}
		
		int answer = 0;
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				answer+=map[i][j];
			}
		}
		System.out.println(answer);
	}
	public static void cloud_move(int d, int s) {
		int length = q.size();
		for(int i=0; i<length; i++) {
			Point p = q.poll();
			//구름을 d 방향으로 s칸 만큼 이동시키기
			int cx = p.x + (s % N) * dx[d];
			int cy = p.y + (s % N) * dy[d];
			
			if(cx < 1) {
				cx += N;
			}else if(cx > N) {
				cx -= N;
			}
			
			if(cy < 1) {
				cy += N;
			}else if(cy > N) {
				cy -= N;
			}
			//이동 후 물양1씩 증가
			map[cx][cy]++;
			q.offer(new Point(cx, cy));
		}
		
	}
	public static void new_cloud() {
		//이전 구름이 삭제된 칸이 아니고 
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(map[i][j] >=2 && cloud[i][j] == 0) {
					map[i][j]-=2;
					q.offer(new Point(i,j));
				}
			}
		}
		
		//새로운 구름 찾았으면 이전 구름 삭제
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(cloud[i][j] == 1) {
					cloud[i][j] = 0;
				}
			}
		}
	}
	public static void water_copy() {
		int length = q.size();
		for(int i=0; i<length; i++) {
			Point p = q.poll();
			int cx = p.x;
			int cy = p.y;
			//물복사버그
			// cx, cy가 움직인 구름 좌표 이므로 대각선 확인해서 값이 있으면 ++
			if(cx == 1) {
				if(cy == 1) {
					if(map[2][2] > 0) map[1][1]++;
				}else if(cy == N) {
					if(map[2][N-1] > 0) map[1][N]++;
				}else {
					if(map[2][cy-1] >0 && map[2][cy+1]>0) map[1][cy]+=2;
					else if(map[2][cy-1] >0 || map[2][cy+1]>0) map[1][cy]++;
				}
			}else if(cx == N) {
				if(cy == 1) {
					if(map[N-1][2] > 0) map[N][1]++;
				}else if(cy == N) {
					if(map[N-1][N-1] > 0) map[N][N]++;
				}else {
					if(map[N-1][cy-1] > 0 && map[N-1][cy+1] >0) map[N][cy]+=2;
					else if(map[N-1][cy-1] > 0 || map[N-1][cy+1] >0) map[N][cy]++;
				}
			}else if(cy==1) {
				if(map[cx-1][2] >0 && map[cx+1][2]>0) map[cx][1]+=2;
				else if(map[cx-1][2] >0 || map[cx+1][2]>0) map[cx][1]++;
			}else if(cy==N) {
				if(map[cx-1][N-1]>0 && map[cx+1][N-1]>0) map[cx][N]+=2;
				else if(map[cx-1][N-1]>0 || map[cx+1][N-1]>0) map[cx][N]++;
			}else {
				//나머지는 네 방향 4각선을 보고 물복사
				if(map[cx-1][cy-1] >0) map[cx][cy]++;
				if(map[cx-1][cy+1] >0) map[cx][cy]++;
				if(map[cx+1][cy-1] >0) map[cx][cy]++;
				if(map[cx+1][cy+1] >0) map[cx][cy]++;
			}
			cloud[cx][cy] = 1;
		}
	}
}
