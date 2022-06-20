import java.util.*;
import java.io.*;
import java.math.*;

public class NO1463 {
	// 1이 될 때까지 최소한의 경우
	static Integer[] dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int x = Integer.parseInt(br.readLine());
		dp = new Integer[x + 1];
		dp[0] = dp[1] = 0;

		System.out.println(cal(x));
	}

	static int cal(int x) {

		if (dp[x] == null) {
			if (x % 6 == 0) {
				dp[x] = Math.min(cal(x - 1), Math.min(cal(x / 3), cal(x / 2))) + 1;
			} else if (x % 3 == 0) {
				dp[x] = Math.min(cal(x / 3), cal(x - 1)) + 1;
			} else if (x % 2 == 0) {
				dp[x] = Math.min(cal(x / 2), cal(x - 1)) + 1;
			} else {
				dp[x] = cal(x - 1) + 1;
			}
		}
		return dp[x];
	}
}
