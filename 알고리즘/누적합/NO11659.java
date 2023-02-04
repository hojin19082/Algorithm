package ДЉРћЧе;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NO11659 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] s = new int[N+1];
		Arrays.fill(s, 0);
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++) {
			int num = Integer.parseInt(st.nextToken());
			s[i] = s[i-1] + num;
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			System.out.println(s[b]-s[a-1]);
			
		}

	}

}
