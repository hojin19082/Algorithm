import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NO2805 {
	private static int n,m;
	private static int tree[];
	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		tree = new int[n];

		int min = 0;
		int max = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			tree[i] = Integer.parseInt(st.nextToken());
			if(max < tree[i]) {
				max = tree[i];
			}
		}
		
		while(min < max) {
			int mid = (min+max)/2;
			long sum = 0;
			for(int i=0; i<n; i++) {
				if(tree[i] > mid) {
					sum += tree[i] - mid;
				}
			}
			if(sum<m) {
				max = mid;
			}else {
				min = mid+1;
			}
		}
		System.out.println(min-1);
	}
}
