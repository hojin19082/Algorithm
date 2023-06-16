package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class A와B2 {
	static int answer = 0;
	static String A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A = br.readLine();
		String B = br.readLine();
		StringBuilder sb = new StringBuilder();
		sb.append(B);
		dfs(sb);
		System.out.println(answer);
	}

	public static void dfs(StringBuilder sb) {
		if (sb.length() == A.length() && sb.toString().equals(A)) {
			answer = 1;
			return;
		}

		if (sb.length() > A.length()) {
			StringBuilder temp = new StringBuilder(sb.toString());

			if (temp.charAt(0) == 'B') {
				sb.deleteCharAt(0).reverse();
				dfs(sb);
				if(temp.charAt(temp.length()-1) == 'A') {
					sb = new StringBuilder(temp.toString());
					sb.deleteCharAt(sb.length()-1);
					dfs(sb);
				}
			}
			
			if (temp.charAt(0) == 'A' && temp.charAt(temp.length() - 1) == 'A') {
				temp.deleteCharAt(temp.length() - 1);
				dfs(temp);
			}

		}
	}
}
