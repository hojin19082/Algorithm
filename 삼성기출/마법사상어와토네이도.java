import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class 마법사상어와토네이도 {
	static int N;
	static int[][] map;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static int[] dc = {1,1,2,2};  // 토네이도의 각 방향으로 이동하는 횟수
	//9방향에 대해 미리 정해두기
	static int[][] dsx = {{-1,1,-2,-1,1,2,-1,1,0}, {-1,-1,0,0,0,0,1,1,2},    //모래가 퍼지는 x방향
            {1,-1,2,1,-1,-2,1,-1,0}, {1,1,0,0,0,0,-1,-1,-2}};
	static int[][] dsy = {{1,1,0,0,0,0,-1,-1,-2},{-1,1,-2,-1,1,2,-1,1,0},    //모래가 퍼지는 y방향
            {-1,-1,0,0,0,0,1,1,2},{1,-1,2,1,-1,-2,1,-1,0}};
	static int[] sandRatio ={1,1,2,7,7,2,10,10,5};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int result = cal((N+1)/2, (N+1)/2);
		System.out.println(result);
	}
	public static int cal(int x, int y){
		int totalSand = 0;
		int currentX = x;
		int currentY = y;
		
		while(true) {
			for(int i=0; i<4; i++) {
				for(int move=0; move<dc[i]; move++) {
					
					int nx = currentX + dx[i];
					int ny = currentY + dy[i];
					if(nx < 1 || ny<1 || nx > N || ny >N) {
						return totalSand;
					}
					
					int sand = map[nx][ny];
					map[nx][ny] = 0;
					int spreadTotal = 0;

					//토네이도 돌리고 모래 퍼진거 구하기 (범위 넘어갔을 때 사라지는 애들도 구하기)
					for(int spread = 0; spread<9; spread++){
                        int sandX = nx + dsx[i][spread];
                        int sandY = ny + dsy[i][spread];
                        int spreadAmount = (sand*sandRatio[spread])/100;

                        if(sandX<1 || sandY<1 || sandX>N || sandY>N){
                            totalSand += spreadAmount;
                        }
                        else{
                            map[sandX][sandY]+=spreadAmount;
                        }
                        spreadTotal+= spreadAmount;
                    }
					
					int ax = nx + dx[i];
					int ay = ny + dy[i];
					int aAmount = sand - spreadTotal;
					if(ax < 1 || ay < 1 || ax > N || ay > N) {
						totalSand+=aAmount;
					}else {
						map[ax][ay] += aAmount;
					}
					
					currentX = nx;
					currentY = ny;
				}
			}
			for(int i=0; i<4; i++) {
				dc[i]+=2;
			}
		}
	}

}
