package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class N과M3 {
	static int N,M;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb;
	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		visited =new boolean[N];
		sb = new StringBuilder();
		backtracking(0);
		System.out.println(sb);
	}
	public static void backtracking(int count) {
		if(count == M) {
			
			for(int val: arr) {
				sb.append(val+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			arr[count] = i+1;
			backtracking(count+1);
			
		}
	}
}

