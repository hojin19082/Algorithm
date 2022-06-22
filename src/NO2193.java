import java.util.*;
import java.io.*;

public class NO2193 {
// ÀÌÄ£¼ö
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N+1];
		dp[0]=0;
		dp[1]=1;
		
		for(int i=2; i<=N; i++) {
			dp[i] = dp[i-2]+dp[i-1];
		}
		System.out.println(dp[N]);
	}

}
