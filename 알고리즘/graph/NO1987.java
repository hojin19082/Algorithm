package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NO1987 {
	
	private static int R,C, ans;
	private static boolean[] alphabet;
	private static int[][] arr;
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[R+1][C+1];
		alphabet = new boolean[26];
		
		for(int i=1; i<=R; i++) {
			String str = br.readLine();
			for(int j=1; j<=C; j++) {
				arr[i][j] = (int) str.charAt(j-1) - 65;
			}
		}
		ans = 0;
		
		dfs(1,1,0);
		System.out.println(ans);
	}
	public static void dfs(int i, int j, int count) {
		if(alphabet[arr[i][j]]) {
			ans = Math.max(ans, count);
			return;
		}else {
		alphabet[arr[i][j]] = true;
		for(int k=0; k<4; k++) {
			int cx = i + dx[k];
			int cy = j + dy[k];
			
			if(cx>0 && cy>0 && cx<R+1 && cy<C+1) {
				dfs(cx,cy, count+1);
				}
			}
		alphabet[arr[i][j]] = false;
		}
	}
}
