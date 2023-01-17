package ÀÌºÐÅ½»ö;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NO2470 {

	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[T];
		for(int i=0; i<T; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int left = 0;
		int right = T-1;
		int ans1 = 0;
		int ans2 = T-1;
		int sum = arr[left]+arr[right];
		
		while(right-left>1) {
			if(arr[left]>0 && arr[right]>0 && left ==0 && right==T-1) {
				ans2 = left+1;
				break;
			}else if (arr[left] <0 && arr[right] <0 && left ==0 && right==T-1) {
				ans1 = right-1;
				break;
			}else {
				if(Math.abs(arr[left])>Math.abs(arr[right])) {
					left++;
				}else if(Math.abs(arr[left])<Math.abs(arr[right])) {
					right--;
				}else {
					break;
				}
				if(Math.abs(arr[left] + arr[right]) < Math.abs(sum)) {
					sum = arr[left] + arr[right];
					ans1 = left;
					ans2 = right;
				}
			}
		}
		System.out.println(arr[ans1] + " " + arr[ans2]);
	}

}
