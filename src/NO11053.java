import java.util.*;
import java.io.*;

public class NO11053 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Integer[] A = new Integer[N];
		Integer[] dp = new Integer[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			dp[i]=1;
		for(int j =0; j<i; j++) {
			if(A[j]<A[i] && dp[i]<dp[j]+1) {
				dp[i] = dp[j]+1;
			}
		}
		}
		int max = 0;
		for(int i =0; i<N; i++) {
			if(dp[i]>max) {
				max = dp[i];
			}
		}
		System.out.println(max);
	}
}
