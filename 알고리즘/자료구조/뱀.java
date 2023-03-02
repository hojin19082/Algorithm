package 자료구조;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 뱀 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayDeque<Point> deque = new ArrayDeque<>();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][N+1];
		int K = Integer.parseInt(br.readLine());
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
		}
		int L = Integer.parseInt(br.readLine());
		int[] change = new int[10002];
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			String c = st.nextToken();
			//오른쪽이면 2
			if(c.equals("D")) {
				change[l+1] = 1;
			}else {
				//왼쪽이면 2
				change[l+1] = 2;
			}
		}
		int answer = 0;
		//현재 진행 방향으로 0이면 오 / 1이면 아 / 2면 왼 / 3이면 위
		int vector = 0;
		Point point = new Point(1,1);
		deque.add(point);
		while(true) {
			answer++;
			
			Point p = new Point(deque.getLast().x, deque.getLast().y);
			//방향전환
			if(change[answer] == 1) {
				if(vector == 3) {
					vector = 0;
				}else {
					vector++;
				}
			}else if(change[answer] == 2) {
				if(vector == 0) {
					vector = 3;
				}else {
					vector--;
				}
			}
			//방향에 맞게 전진할 칸
			if(vector == 0) {
				p.y++;
			}else if(vector == 1) {
				p.x++;
			}else if(vector == 2) {
				p.y--;
			}else if(vector == 3) {
				p.x--;
			}
			
			//벽에 부딪히면 끝
			if(p.x ==0 || p.x == N+1 || p.y ==0 || p.y == N+1) {
				break;
			}
			
			if(deque.contains(new Point(p.x, p.y))) {
				break;
			}
			
			if(map[p.x][p.y] == 1) {
				//사과가 있으므로 길이늘리기
				deque.add(p);
			}else {
				deque.pollFirst();
				deque.add(p);
			}
		}
		System.out.println(answer);
	}

}
