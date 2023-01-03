import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NO14501 {

	private static int t[];
	private static int p[];
	private static int dp[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		t = new int[N+1];
		p = new int[N+1];
		dp = new int[N+2];
		int max = 0;
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<N+1; i++) {
			if(i+t[i]<=N+1) {
				dp[i + t[i]] = Math.max(dp[i+t[i]], dp[i] + p[i]);
			}
			dp[i+1] = Math.max(dp[i+1], dp[i]);
		}
		System.out.println(dp[N+1]);
	}
	

}
