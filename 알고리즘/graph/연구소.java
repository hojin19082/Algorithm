package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.Point;
public class 연구소 {
	static int[][] map;
	static int answer;
	static int N, M;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		answer = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
		System.out.println(answer);
	}
	public static void dfs(int count) {
		if(count == 3) {
			bfs();
			return;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					map[i][j] =1;
					dfs(count+1);
					map[i][j] = 0;
				}
			}
		}
		
	}
	public static void bfs() {
		Queue<Point> q = new LinkedList<>();
		int[][] virus = new int[N][M];
		
		for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                virus[i][j] = map[i][j];
            }
        }
		//2일 때 바이러스
		for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virus[i][j] == 2) {
                    q.add(new Point(i, j));
                }
            }
        }
		
		while(!q.isEmpty()){
			Point p = q.poll();
			for(int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				 if (ny >= 0 && nx >= 0 && nx < N && ny < M) {
	                    if (virus[nx][ny] == 0) {
	                        virus[nx][ny] = 2;
	                        q.add(new Point(nx, ny));
	                    }
	                }
			}
		}
		int temp = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(virus[i][j] == 0) {
					temp++;
				}
			}
		}
		answer = Math.max(answer, temp);
	}

}
