import java.util.*;
import java.io.*;

public class NO9095 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int[] dp = new int[11];
	dp[0] = 0;
	dp[1] = 1;
	dp[2] = 2;
	dp[3] = 4;
	
	int T = Integer.parseInt(br.readLine());
	for(int i = 0 ; i<T; i++) {
		int N = Integer.parseInt(br.readLine());
		for(int j = 4; j<=N; j++) {
			dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
		}
		System.out.println(dp[N]);
	}
	}

}
