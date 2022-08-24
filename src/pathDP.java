import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class pathDP {
	static final int INF = 99999999;
	static int[][] p;
	static int n;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int [][] dp = new int[n+1][n+1];
		int [][] map = new int [n+1][n+1];
		p = new int [n+1][n+1];
		
		for(int i=0; i<n+1; i++) {
			dp[i][0] = INF;
			dp[0][i] = INF;
		}
		for(int i=1; i<n+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<n+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(i==1 && j==1) {
					dp[i][j] = map[i][j];
					p[i][j] = 1;
				}else {
					if(dp[i-1][j] > dp[i][j-1]) {
						dp[i][j] = map[i][j] + dp[i][j-1];
						p[i][j] = 2;
					}else {
						dp[i][j] = map[i][j] + dp[i-1][j];
						p[i][j] = 3;
					}
				}
			}
		}
		System.out.println("n,n까지의 최단 경로");
		printPath();
		System.out.println();
		
		System.out.println("n,n까지의 최단거리: " + dp[n][n]);
	}

	public static void printPath() {
		int i = n, j = n;
		while(p[i][j] != 1) {
			System.out.print("(" + i + "," + j + ")");
			if(p[i][j] == 2) {
				j = j-1;
			}else {
				i = i-1;
			}
			System.out.println();
		}
		System.out.print("("+ i + "," + j+ ")");
	}
}
