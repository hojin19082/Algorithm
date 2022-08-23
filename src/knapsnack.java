import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class knapsnack {
	static int[][] dp;
	static int[][] pw;
	static int n, w;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		pw = new int[n+1][2];
		
		for(int i=1; i<n+1; i++) {
			st = new StringTokenizer(br.readLine());
			//무게
			pw[i][0] = Integer.parseInt(st.nextToken());
			//가치
			pw[i][1] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[n+1][w+1];
		
		for(int i=0; i<n+1; i++) {
			dp[i][0] = 0;
		}
		for(int i=0; i<w+1; i++) {
			dp[0][i] = 0;
		}

		for(int i=1; i<n+1; i++) {
			for(int j=1; j<w+1; j++) {
				//아이템을 선택했을 때 그 아이템의 무게가 현재 배낭의 잔여공간보다 크면
				//이전 값을 그대로
				if(pw[i][0] > j) {
					dp[i][j] = dp[i-1][j];
				}else {
					// 이전 값과 (현재 아이템의 가격 + 현재 아이템의 무게를 뺸 잔여 공간에 들어있는 아이템의 가격) 비교
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-pw[i][0]] + pw[i][1]);
				}
			}
		}
		System.out.println(dp[n][w]);
	}

}
