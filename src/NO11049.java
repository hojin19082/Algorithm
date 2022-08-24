import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class NO11049 {
	static final int INF = 99999999;
	static int[][] m;
	static int [] p;
	static int n;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		m = new int[n+1][n+1];
		p = new int[n+1];
		for(int i=0; i<n; i++) {
			m[i][i] = 0;
			st = new StringTokenizer(br.readLine());
			p[i] = Integer.parseInt(st.nextToken());
			p[i+1] = Integer.parseInt(st.nextToken());
		}
		
		for(int r=1; r<=n-1; r++) {
			for(int i=1; i<=n-r; i++) {
				int j = i+r;
				m[i][j] = m[i+1][j] + (p[i-1] * p[i] * p[j]);
				for(int k= i+1; k<=j-1; k++) {
					if(m[i][j] > m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j]) {
						m[i][j] = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
					}
				}
			}
		}
		System.out.println(m[1][n]);
	}

}
