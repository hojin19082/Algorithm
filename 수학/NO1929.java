import java.util.*;
import java.io.*;

public class NO1929 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		boolean[] prime = new boolean[N+1];
		prime[0] = prime[1] = true;
		
		for(int i=2; i<Math.sqrt(N); i++) {
			for(int j=i*i; j<N+1; j+=i) {
				prime[j] = true;
			}
		}
		for(int i=M; i<=N; i++) {
			if(prime[i] == false) {
				System.out.println(i);
			}
		}
	}

}
