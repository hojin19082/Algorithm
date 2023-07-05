package 누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 블로그 {

	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] sum = new int[N+1];
		for(int i=1; i<=N; i++) {
			sum[i] = sum[i-1] + arr[i];
		}
		int max = sum[X];
		int maxCnt = 1;
		for(int i=X+1; i<=N; i++) {
			int visitor = sum[i] - sum[i-X];
			if(max == visitor) maxCnt++;
			else if(max < visitor) {
				max = visitor;
				maxCnt = 1;
			}
		}

		if(max == 0) {
			System.out.println("SAD");
			return;
		}
		System.out.println(max);
		System.out.println(maxCnt);
	}

}
