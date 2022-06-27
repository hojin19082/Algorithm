import java.util.*;
import java.io.*;

public class NO11055 {
	public static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = A[0];
		for(int i=1; i<N; i++) {
			dp[i] = A[i];
			for(int j=0; j<i; j++) {
				if(A[j]<A[i] && dp[i]<dp[j]+A[i]) {
					dp[i] = dp[j] + A[i];
				}
			}
		}

		for(int i =0; i<N; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

}
