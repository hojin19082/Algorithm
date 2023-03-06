package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소수의연속합 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N==1) {
			System.out.println(0);
			return;
		}
		int[] arr = new int[N+1];
		for(int i=1; i<N+1; i++) {
			arr[i] = i;
		}
		
		arr[1] = 0;
		for(int i=2; i<=N; i++) {
			for(int j=2*i; j<=N; j=j+i) {
				if(arr[j] == 0) continue;
				arr[j] = 0;
			}
		}
		int start = 2;
		int end = 2;
		int sum = arr[start];
		int count = 0;
		if(arr[N] !=0) {
			count++;
		}
		while(end<=N && start<=end) {
			if(end == N) break;
			if(sum >= N) {
				while(sum >= N && start<end) {
					if(sum == N) count++;
					sum-=arr[start];
					start++;
					while(arr[start] == 0 && start<end) {
						start++;
					}
				}
			}else {
				end++;
				while(arr[end] == 0 && end < N) {
					end++;
				}
				sum+=arr[end];
			}
			
		}
		
		System.out.println(count);
	}
}
