import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class NO7576 {
	private static int M,N,cnt;
	private static int map[][];
	private static int tomato[] = {0,0,0};
	private static boolean visited[][];
	private static Queue<Point> queue;
	private static int dx[] = {-1, 1, 0, 0};
	private static int dy[] = {0, 0, -1, 1};
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		queue = new LinkedList<Point>();
		cnt = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int a = Integer.parseInt(st.nextToken());
				if(a==-1) {
					tomato[0]++;
				}else if(a==0) {
					tomato[1]++;
				}else {
					tomato[2]++;
					queue.add(new Point(i,j));
					visited[i][j] = true;
				}
				map[i][j] = a;
			}
		}
		if(tomato[1] !=0) {
			bfs(queue);
			if(tomato[1] != 0) {
				System.out.println("-1");
			}else {
				System.out.println(cnt);
			}
		}else {
			System.out.println("0");
		}
		//그래프 탐색을 마친 후 0이 아직도 존재하면 -1
		// '' 0이 더 이상 없으면 0
		//나머진 day 출력
		
	}
	public static void bfs(Queue<Point> queue) {
		int length = queue.size();
		while(!queue.isEmpty()) {
			
			if(length == 0) {
				cnt++;
				length = queue.size();
			}
			Point p = queue.poll();
			for(int i=0; i<4; i++) {
				int nextX = p.x + dx[i];
				int nextY = p.y + dy[i];
				if(nextX >=0 && nextY >=0 && nextX<N && nextY<M) {
					if(!visited[nextX][nextY] && map[nextX][nextY] == 0) {
						visited[nextX][nextY] = true;
						tomato[1]--;
						queue.add(new Point(nextX, nextY));
					}
				}
			}
			length--;
		}
		
		
	}

}
