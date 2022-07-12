import java.util.*;
import java.io.*;

public class NO2745 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String N = st.nextToken();
		int B = Integer.parseInt(st.nextToken());
		int sum = 0;
		for(int i=0; i<N.length(); i++) {
			if('0'<=N.charAt(i) && '9' >= N.charAt(i)) {
				System.out.println(N.charAt(i)-'0');
				sum = sum*B+(N.charAt(i)-'0');
			}else {
				System.out.println(N.charAt(i)-'A' + 10);
				sum = sum*B+(N.charAt(i)-'A' + 10);
			}

		}
		System.out.println(sum);
	}
	
}
