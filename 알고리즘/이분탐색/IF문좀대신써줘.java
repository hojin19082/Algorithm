package ¿Ã∫–≈Ωªˆ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IFπÆ¡ª¥ÎΩ≈Ω·¡‡ {
	static String[] arr;
	static int[] score;
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new String[N];
		score = new int[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = st.nextToken();
			score[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(compare(num)).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static String compare(int num) {
		
		int left = 0;
		int right = N-1;
		while(left<=right) {
			int mid = (left+right)/2;
			if(score[mid] >= num) {
				right = mid -1;
			}else {
				left = mid+1;
			}
		}
		return arr[left];
		
	}
}
