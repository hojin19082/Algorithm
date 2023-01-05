import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NO1932 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] arr = new int[N+1][N+1];
		int[][] dp = new int[N+1][N+1];
		
		for (int i=1; i<N+1; i++) {
				st = new StringTokenizer(br.readLine());
				int j = 1;
				while(st.hasMoreTokens()) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					j++;
				}
			}
		
		dp[1][1] = arr[1][1];
		for(int i=2; i<N+1; i++) {
			for(int j=1; j<i+1; j++) {
				if(j>1 && j<i+1) {
					dp[i][j] = Math.max(dp[i-1][j-1] + arr[i][j], dp[i-1][j] + arr[i][j]);
				}else if(j==1) {
					dp[i][j] = dp[i-1][j] + arr[i][j];
				}else {
					dp[i][j] = dp[i-1][j-1] + arr[i][j];
				}
			}
		}
		
		int max = 0;
		for(int i=1; i<N+1; i++) {
			if(max<dp[N][i]) {
				max = dp[N][i];
			}
		}
		System.out.println(max);
	}

}
