import java.util.*;
import java.io.*;

public class NO1912 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		long dp[] = new long[n];
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = arr[0];
		long max = dp[0];
		for(int i=1; i<n; i++) {
			dp[i] = Math.max(dp[i-1] + arr[i] , Math.max(arr[i-1] + arr[i], arr[i]));
			if(max < dp[i]) {
				max = dp[i];
			}
		}
		System.out.println(max);
	}

}
