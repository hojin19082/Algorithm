import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NO10451 {
	static int [][] map;
	static boolean[] visited;
	static int n;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=0; tc<t; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n+1][n+1];
			visited=new boolean[n+1];
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int i=1; i<n+1; i++) {
				for(int j=1; j<n+1; j++) {
					map[i][j] = 0;
				}
			}
			
			for(int i=1; i<n+1; i++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][num] = 1;
			}
			int cnt = 0;
			for(int i=1; i<n+1; i++) {
				if(!visited[i]) {
					dfs(i);
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
	public static void dfs(int start) {
		visited[start] = true;
		for(int i=1; i<n+1; i++) {
			if(map[start][i] == i) {
				return;
			}else if(!visited[i] && map[start][i] != 0) {
				dfs(i);
			}
		}
	}
}
