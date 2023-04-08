
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
public class 주사위굴리기2 {
	static int[][] map;
	static boolean[][] visited;
	//주사위 이동 후 같은 값 찾을 때
	static int[] dx = {0,0,1,0,-1};
	static int[] dy = {0,1,0,-1,0};
	static int[] dice;
	static int x,y,dir;
	static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		map = new int[n+1][m+1];
		dice = new int[7];
		for(int i=1; i<7; i++) {
			dice[i] = i;
		}
		x = y = dir = 1;
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		for(int i=0; i<k; i++) {
			dice_move();
			//주사위 이동 후 밑면과 판 점수 확인 후 방향 전환
			check_dir();
			
			//(x,y)칸이랑 같은 값을 가지는 동서남북으로 갈 수 있는 칸 개수 구하기
			int score = check_move();
			answer += score;
		}
		System.out.println(answer);

	}
	public static void dice_move() {
		int temp = dice[1];
		//만약 현재 방향으로 갈 수 없다면
		int cx = x+dx[dir];
		int cy = y+dy[dir];
		if(cx < 1 || cx > n || cy <1 || cy >m) {
			dir = dir+2;
			if(dir > 4) {
				dir-=4;
			}
			cx = x + dx[dir];
			cy = y + dy[dir];
		}
		x = cx;
		y = cy;
		//방향 1 ~ 4까지 동 ~ 북
		if(dir == 1) {
			dice[1] = dice[4];
			dice[4] = dice[6];
			dice[6] = dice[3];
			dice[3] = temp;
		}else if(dir == 2) {
			dice[1] = dice[2];
			dice[2] = dice[6];
			dice[6] = dice[5];
			dice[5] = temp;
		}else if(dir == 3) {
			dice[1] = dice[3];
			dice[3] = dice[6];
			dice[6] = dice[4];
			dice[4] = temp;
		}else {
			dice[1] = dice[5];
			dice[5] = dice[6];
			dice[6] = dice[2];
			dice[2] = temp;
		}

	}
	public static void check_dir() {
		if(map[x][y] == dice[6]) return;
		if(dice[6] > map[x][y]) {
			dir++;
			if(dir == 5) {
				dir = 1;
			}
		}else {
			dir--;
			if(dir == 0) {
				dir = 4;
			}
		}
	}
	public static int check_move() {
		Queue<Dice> q = new LinkedList<>();
		q.offer(new Dice(x,y));
		int count = 1;
		int num = map[x][y];
		visited = new boolean[n+1][m+1];
		visited[x][y] = true;
		while(!q.isEmpty()) {
			Dice node = q.poll();
			for(int i=1; i<=4; i++) {
				int cx = node.x + dx[i];
				int cy = node.y + dy[i];
				
				if(cx < 1 || cx > n || cy <1 || cy >m || visited[cx][cy]) continue;
				
				if(map[cx][cy] == num) {
					visited[cx][cy] = true;
					count++;
					q.offer(new Dice(cx,cy));
				}
			}
		}
		return count * num;
	}

}
class Dice{
	int x;
	int y;
	Dice(int x , int y){
		this.x = x;
		this.y = y;
	}
}