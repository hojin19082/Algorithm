package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class N과M2 {
	static int N,M;
	static int[] arr;
	static boolean[] visited;
	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		visited =new boolean[N];
		backtracking(0,0);
	}
	public static void backtracking(int count, int prev) {
		if(count == M) {
			for(int val: arr) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				if(prev > i) continue;
				visited[i]= true;
				arr[count] = i+1;
				backtracking(count+1,i+1);
				visited[i] = false;
			}
		}
	}
}

