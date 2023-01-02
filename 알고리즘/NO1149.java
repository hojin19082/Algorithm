import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NO1149 {
	//1번과 2번은 색이 다름, N번은 N-1과 색이 다름
	//i는(2~N-1사이) i-1, i+1과 색이 다름.
	//위 조건을 모두 만족하는 비용 최솟 값
	
	private static int dp[][];
	private static int arr[][];
	private static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		dp = new int[N+1][3];
		arr = new int[N+1][3];
		StringTokenizer st;
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		for(int i=2; i<=N; i++) {
			dp[i][0] = INF;
			dp[i][1] = INF;
			dp[i][2] = INF;
		}
		dp[1][0] = arr[1][0];
		dp[1][1] = arr[1][1];
		dp[1][2] = arr[1][2];
		
		for(int i=2; i<=N; i++) {
			for(int j=0; j<3; j++) {
				for(int k=0; k<3; k++) {
					if(j !=k && dp[i][j] > dp[i-1][k] + arr[i][j]) {
						dp[i][j] = dp[i-1][k] + arr[i][j];
						}
					}
				}
			}
		
		int min = dp[N][0];
		for(int i=0; i<3; i++) {
			if(min > dp[N][i]) {
				min = dp[N][i];
			}
		}
		System.out.println(min);
	}
}
