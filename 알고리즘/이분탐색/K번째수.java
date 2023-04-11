package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class K번째수 {
	static int N, K;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		long left = 1;
		long right = N*N;
		while(left<right) {
			long mid = (left + right)/2;
			//left~ mid 까지 약수 구하기
			long count = 0;
			for(int i=1; i<=N; i++) {
				count += Math.min(mid/i, N);
			}
			
			if(count>=K) {
				right = mid;
			}else {
				left = mid +1;
			}
		}
		System.out.println(left);
		
	}


}
