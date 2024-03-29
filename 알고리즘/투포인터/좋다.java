package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋다 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Math.abs(Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr);

		int answer = 0;
		for(int i=0; i<N; i++) {
			int left = 0;
			int right = N-1;
			
			while(true) {
				if(left == i) left++;
				else if(right == i) right--;
				
				if(left >= right) break;
				
				if(arr[left] + arr[right] == arr[i]) {
					answer++;
					break;
				}else if(arr[left] + arr[right] > arr[i]) {
					right--;
				}else {
					left++;
				}
			}
			
		}
		
		System.out.println(answer);
	}

}
