package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 오큰수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		int t = Integer.parseInt(br.readLine());
		int[] arr = new int[t];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<t; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] pop = new int[t];
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<t; i++) {
			if(stack.isEmpty() || arr[stack.peek()] > arr[i]) {
				stack.push(i);
			}else {
				while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
					pop[stack.pop()] = arr[i];
				}
				stack.push(i);
			}
		}
		
		while(!stack.isEmpty()) {
			pop[stack.pop()] = -1;
		}
		
		for(int i=0; i<t; i++) {
			sb.append(pop[i] + " ");
		}
		System.out.println(sb.toString());
	}

}
