import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NO1654 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		long right = 0;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(right<arr[i]) {
				right = arr[i];
			}
		}
		
		long left = 0;
		right++;
		
		while(left < right) {
			long mid = (left+right)/2;
			long count = 0;
				for(int i=0; i<N; i++) {
					count += (arr[i]/mid);
				}
				if(count < M) {
					right = mid;
				}else {
					left = mid + 1;
				}

		}
		System.out.println(left-1);
	}

}
