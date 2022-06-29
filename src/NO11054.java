import java.util.*;
import java.io.*;

public class NO11054 {
	public static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] dp1 = new int[N];
		int[] dp2 = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		dp1[0] = 1;
		dp2[0] = 1;
		
		for(int i =1; i<N; i++) {
			dp1[i] = 1;
			for(int j=0; j<i; j++) {
				if(A[i]>A[j] && dp1[i]<dp1[j]+1) {
					dp1[i] = dp1[j] + 1;
			}
		}
		}
		for(int i=N-1; i>=0; i--) {
			dp2[i] = 1;
			for(int j=i; j<=N-1; j++) {
				if(A[i]>A[j] && dp2[i]<dp2[j]+1) {
					dp2[i] = dp2[j] + 1;
			}
		}
		}
			
		
		for(int i =0; i<N; i++) {
			max = Math.max(max, dp1[i]+dp2[i]-1);
		}
		
		System.out.println(max);
	}

}
