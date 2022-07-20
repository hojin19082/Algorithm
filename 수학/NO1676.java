import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class NO1676 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		BigInteger big = new BigInteger("1");
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			big = big.multiply(BigInteger.valueOf(i));
		}
		String S = big.toString();
		for(int i=S.length() -1; i>1; i--) {
			if(S.charAt(i) - '0' ==0) {
				cnt++;
			}else {
				break;
			}
		}
		System.out.println(cnt);

	}

}
