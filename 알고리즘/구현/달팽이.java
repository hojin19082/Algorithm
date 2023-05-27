package 손코딩;
import java.io.*;
public class 달팽이 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][N+1];
		int[] road = {1,1,2,2};
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		int value = 1;
		int startX = N/2 +1 , startY = N/2 +1;
		map[startX][startY] = value++;
		while(true) {
			for(int i=0; i<4; i++){
				for(int j=0; j<road[i]; j++) {
					startX += dx[i];
					startY += dy[i];
					map[startX][startY] = value++;
					if(value == N*N +1) break;
				}
				if(value == N*N +1) break;
				road[i]+=2;
			}
			if(value == N*N +1) break;
		}
		int answerX =0;
		int answerY =0;
		StringBuilder sb =new StringBuilder();
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(M == map[i][j]) {
					answerX = i;
					answerY = j;
				}
				sb.append(map[i][j] + " ");
			}
			sb.append('\n');
		}
		sb.append(answerX +" " +answerY);
		System.out.println(sb.toString());
	}

}