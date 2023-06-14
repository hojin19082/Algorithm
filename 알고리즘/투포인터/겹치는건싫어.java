package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 겹치는건싫어 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] temp = new int[100001];
		int answer = 0;
		int start = 0;
		int end = 0;
		while(end<arr.length) {
			while(end < arr.length && temp[arr[end]]+1 <= K) {
				temp[arr[end]]++;
				end++;
			}
			int len = end - start;
			answer = Math.max(answer,  len);
			temp[arr[start]]--;
			start++;
		}
		System.out.println(answer);
	}
}
