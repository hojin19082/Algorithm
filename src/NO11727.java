import java.util.*;
import java.io.*;

public class NO11727 {
 //2*n Ÿ�� ����Ǽ� (+ 2*2Ÿ�� �߰�)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 3;
        for(int i=3; i<=n; i++) {
        	dp[i] = (dp[i-1]+ 2*dp[i-2])%10007;
        }
        System.out.println(dp[n]);
	}

}
