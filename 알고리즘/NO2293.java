import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NO2293 {
	//n개의 종류 동전을 가지고 k원을 만들 수 있는 경우의 수 구하기
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