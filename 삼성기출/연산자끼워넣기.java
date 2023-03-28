import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {
	//다시 풀기 성공
	static int N;
	static int[] arr;
	static int[] op;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		op = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		for(int j=0; j<4; j++) {
			if(op[j]==0) continue;
			int result = arr[0];
			op[j]--;
			dfs(result, j, 1);
			op[j]++;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(max).append('\n').append(min);
		System.out.println(sb.toString());
	}
	public static void dfs(int result,int pp, int count) {
			if(pp==0) {
				result += arr[count];
			}else if(pp == 1) {
				result -= arr[count];
			}else if(pp == 2){
				result *= arr[count];
			}else if(pp == 3) {
				result /= arr[count];
			}
			for(int j=0; j<4; j++) {
				if(op[j]==0) continue;
				op[j]--;
				dfs(result, j, count+1);
				op[j]++;
			}
		
		
		if(count== N-1) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		
	}
 
}