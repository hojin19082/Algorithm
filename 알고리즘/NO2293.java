import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NO2293 {

	private static int dp[];
	private static int arr[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		dp = new int[K+1];
		arr = new int[N+1];
		for(int i=1; i<=N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = 1;
		
		for(int i=1; i<=N; i++) {
			for(int j=arr[i]; j<=K; j++) {
				dp[j] = dp[j] + dp[j-arr[i]];
			}
		}
		
		System.out.println(dp[K]);
	}
}