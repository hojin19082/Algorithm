import java.util.*;
import java.io.*;

public class NO1978 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = 0;
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			boolean isPrime = true;
			if(num==1) {
				continue;
			}
			for(int j=2; j<=Math.sqrt(num); j++) {
				if(num % j == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
