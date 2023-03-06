package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 부분합 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0, end = 0;
		int sum = arr[start];
		int length = Integer.MAX_VALUE;
		
		while(end <= N-1) {
			
			if(sum >= S) {
				while(start <= end && sum >= S) {
					length = Math.min(length, end-start+1);
					sum = sum - arr[start];
					start++;
				}
			}else {
				if(end == N-1) break;
				end++;
				sum = sum + arr[end];
			}
			
		}
		if(length == Integer.MAX_VALUE) {
			System.out.println(0);
		}else {
			System.out.println(length);
		}
	}

}
