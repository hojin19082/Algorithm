import java.util.*;
import java.io.*;

public class NO1850 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long gcd = gcd(Math.max(A, B), Math.min(A, B));
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<gcd; i++) {
			sb.append("1");
		}
		System.out.println(sb.toString());
	}

	public static long gcd(long a, long b) {
		if(b == 0 ) return a;
		else {
			return gcd(b,a%b);
		}
    }
}
