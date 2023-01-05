import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NO9461 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<N+1; i++) {
			int p = Integer.parseInt(br.readLine());
			if(p>=1 && p<=100) {
				long[] dp = new long[p+1];
				if(p==1) {
					dp[1] = 1;
				}else if(p==2) {
					dp[1] = dp[2] = 1;
				}else {
					dp[1] = dp[2] = dp[3] = 1;
				}
				for(int j=4; j<p+1; j++) {
					dp[j] = dp[j-3] + dp[j-2];
				}
				System.out.println(dp[p]);
			}
		}

	}

}
