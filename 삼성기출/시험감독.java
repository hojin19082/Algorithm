package 삼성기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class 시험감독 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		long answer = N;
		for(int i=0; i<N; i++) {
			arr[i] -= B;
			if(arr[i] > 0) {
				int mok = arr[i] / C;
				int nmg = arr[i] % C;
				if(nmg > 0) {
					answer+= (long)(mok+1);
				}else {
					answer+= (long)mok;
				}
			}
		}
		System.out.println(answer);
		
	}

}
