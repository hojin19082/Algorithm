package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
public class 왼큰수 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		int[] arr= new int[N];
		int[] answer = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=N-1; i>=0; i--) {
			if(stack.isEmpty() || arr[stack.peek()] > arr[i]) {
				stack.push(i);
			}else {
				while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
					answer[stack.pop()] = i+1;
				}
				stack.push(i);
			}
		}
		for(int i=0; i<stack.size(); i++) {
			answer[stack.pop()] = 0;
		}
		
		for(int i=0; i<answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
		
	}

}
