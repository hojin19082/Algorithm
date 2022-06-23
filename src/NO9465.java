import java.util.*;
import java.io.*;
public class NO9465 {
// 가장 많은 합 스티커 뽑기
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[][] score = new int[2][N+1];
			int[][] dp = new int[2][N+1];
			
			for(int j=0; j<2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k=1; k<=N; k++) {
					score[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[0][1] = score[0][1];
			dp[1][1] = score[1][1];
			
			for(int a = 2; a<=N; a++) {
				dp[0][a] = Math.max(dp[1][a-1], dp[1][a-2]) + score[0][a];
				dp[1][a] = Math.max(dp[0][a-1], dp[0][a-2]) + score[1][a];
			}
			System.out.println(Math.max(dp[0][N], dp[1][N]));
		}
		
	}

}
