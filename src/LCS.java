import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class LCS {
	//matrix chain °ö
	static int[][] lcs;
	static int n, m;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		n = str1.length();
		m = str2.length();
		
		lcs = new int[n+1][m+1];
		
		for(int i=0; i<n+1; i++) {
			lcs[i][0] = 0;
		}
		for(int i=0; i<m+1; i++) {
			lcs[0][i] = 0;
		}
		
		for(int i=0; i<n; i++) {
			char ch1 = str1.charAt(i);
			for(int j=0; j<m; j++) {
				char ch2 = str2.charAt(j);
				if(ch1 == ch2) {
					lcs[i+1][j+1] = lcs[i][j] + 1;
				}else {
					lcs[i+1][j+1] = Math.max(lcs[i][j+1], lcs[i+1][j]);
				}
			}
		}
		System.out.println(lcs[n][m]);

	}

}
