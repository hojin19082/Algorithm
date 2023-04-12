package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 과자나눠주기 {
	static int N,M;
	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];

		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int left= 1;
		int right = arr[N-1];
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			int count=0;
			for(int i=0; i<N; i++) {
				if(arr[i] >= mid) {
					count += arr[i]/mid;
				}
			}
			if(count >= M) {
				left = mid +1;
			}else {
				right = mid-1;
			}
		}
		System.out.println(right);
	}

}
