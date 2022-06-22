import java.util.*;
import java.io.*;

public class NO2156 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int[] wine = new int[T + 1];
		int[] dp = new int[T + 1];
		for (int i = 1; i <= T; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = wine[1];
		if(T>1) {
			dp[2] = wine[1] + wine[2];
		}
		for (int i = 3; i <= T; i++) {
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+wine[i] , dp[i-3] + wine[i-1]+wine[i]));
		}
		System.out.println(dp[T]);
	}
}
