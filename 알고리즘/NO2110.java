import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NO2110 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int left = 1;
		int right = arr[N-1] - arr[0] + 1;
		
		while(left<right) {
			int mid = (left+right)/2;
			
			int count = 1;
			int pre = arr[0];
			
			for(int i=1; i<N; i++) {
				int cur = arr[i];
				
				if(cur-pre >= mid) {
					count++;
					pre = cur;
				}
			}
			
			if(count < M) {
				right = mid;
			}else{
				left = mid + 1;
			}
		}
		System.out.println(left-1);
	}

}
