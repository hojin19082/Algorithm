package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열2 {

	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] lis = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		lis[0] = arr[0];
		int count = 1;
		for(int i=1; i<N; i++) {
			if(lis[count-1] < arr[i]) {
				lis[count++] = arr[i];
			}else {
				int idx = bst(lis, arr[i], 0, count);
				lis[idx] = arr[i];
			}
		}
		int answer =0;
		for(int i=0; i<N; i++) {
			if(lis[i] > 0) {
				answer++;
			}
		}
		System.out.println(answer);
	}
	public static int bst(int[] lis, int value, int s, int e) {
		while(s<e){
			int mid = s+(e-s)/2;
			if(value <= lis[mid]) {
				e = mid;
			}else {
				s= mid+1;
			}
		}
		return s;
	}
}
