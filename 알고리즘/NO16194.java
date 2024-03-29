import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NO16194 {

	private static int dp[];
	private static int arr[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		dp = new int[N+1];
		arr = new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for(int i=1; i<=N; i++) {
			for(int j=1; j<=i; j++) {
				if(j == 1) {
					dp[i] = dp[i-j] + arr[j];
				}else {
					dp[i] = Math.min(dp[i], dp[i-j] + arr[j]);
				}
			}
		}
		
		System.out.println(dp[N]);
	}

}
