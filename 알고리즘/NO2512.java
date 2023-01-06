import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NO2512 {

	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int budget = Integer.parseInt(br.readLine());
		
		int left = 0;
		int right = arr[N-1];
		
		while(left<=right) {
			int mid = (left+right)/2;
			long sum = 0;
			for(int i=0; i<N; i++) {
				if(arr[i] < mid) {
					sum = sum + arr[i];
				}else {
					sum = sum + mid;
				}
			}
			if(sum<=budget) {
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		System.out.println(left-1);
	}

}
