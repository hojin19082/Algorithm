import java.util.*;
import java.io.*;

public class NO11057 {
// 오르막 수
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[N + 1][10];
		
		for (int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		for(int i=2; i<=N; i++) {
			for(int j=9; j>=0; j--) {
				if(j==9) {
					dp[i][9] = 1;
				}else {
					dp[i][j] = (dp[i][j+1] + dp[i-1][j]) % 10007;
				}
			}
		}
		long result = 0;
		for(int i=0; i<10; i++) {
			result = (result + dp[N][i]) % 10007;
		}
		System.out.println(result);
	}
}
