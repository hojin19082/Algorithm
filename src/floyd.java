import java.util.*;
import java.io.*;
public class floyd {
	static int [][] d;
	static final int INF = 999999999;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st;
		d = new int[n+1][n+1];
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				d[i][j] = INF;
				if (i == j) {
                    d[i][j] = 0;
                }
			}
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			if(d[u][v] > weight) {
				d[u][v] = weight;
			}
		}

		for(int k=1; k<n+1; k++) {
			for(int i=1; i<n+1; i++) {
				for(int j=1; j<n+1; j++) {
					if(d[i][j] > d[i][k] + d[k][j]) {
						d[i][j] = d[i][k] + d[k][j];
					}
				}
			}
		}
		System.out.println();
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(d[i][j] == INF) {
					d[i][j] = 0;
				}
				System.out.print(d[i][j] +" ");
			}
			System.out.println();
		}
	}

}
