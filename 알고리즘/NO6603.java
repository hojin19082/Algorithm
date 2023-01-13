import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NO6603 {
	private static int K;
	private static int[] arr;
	private static int[] result;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			if(K==0) {
				break;
			}
			arr = new int[K];
			result = new int[K];
			for(int i=0; i<K; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			dfs(0,0);
			
			System.out.println();
		}
	}
	public static void dfs(int start, int depth) {
		if(depth == 6) {
			print();
		}
		for(int i=start; i<K; i++) {
			result[i] = 1;
			dfs(i+1, depth+1);
			result[i] = 0;
		}
	}
	public static void print() {
		for(int i=0; i<K; i++) {
			if(result[i] == 1) {
				System.out.print(arr[i] +" ");
			}
		}
		System.out.println();
	}
	
}
