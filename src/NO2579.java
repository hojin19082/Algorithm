import java.util.*;
import java.io.*;

public class NO2579 {
	static int[] arr;
	static long[] dp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		dp = new long[n+1];
		arr = new int[n+1];

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = 0;
		dp[1] = arr[1];
		
		if(n>=2) {
			dp[2] = arr[1] + arr[2];
		}
		
		for(int i=3; i<=n; i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];
			
		}
		
		
		System.out.println(dp[n]);

	}

}