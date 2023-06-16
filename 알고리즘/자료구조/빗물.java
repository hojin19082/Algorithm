package 자료구조;

import java.io.*;
import java.util.*;
public class 빗물 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[W];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = 1;
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		while(right < arr.length) {
			if(arr[left] <= arr[right]) {
				if(arr[left] == arr[right]) {
					while(!stack.isEmpty()) {
						answer+= arr[right] - stack.pop();
					}
				}else if(arr[left] < arr[right]) {
					while(!stack.isEmpty()) {
						answer += arr[left] - stack.pop();
					}
				}
				left = right;
			}else {
				stack.add(arr[right]);
			}
			right++;
		}
		if(!stack.isEmpty()) {
			int pop = stack.pop();
			while(!stack.isEmpty()) {
				if(pop > stack.peek()) {
					answer+= pop-stack.pop();
				}else {
					pop = stack.pop();
				}
				
			}
		}
		System.out.println(answer);
	}

}
