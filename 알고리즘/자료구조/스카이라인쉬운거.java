package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 스카이라인쉬운거 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int count = 0;
		
		Stack<Integer> stack = new Stack();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
	
			if((y>0 && stack.isEmpty()) || (!stack.isEmpty() && stack.peek() < y)) {
				stack.add(y);
			}else if(!stack.isEmpty() && stack.peek() > y) {
				while(!stack.isEmpty() && stack.peek() > y) {
					stack.pop();
					count++;
				}

				if((y > 0 && stack.isEmpty()) || (!stack.isEmpty() && stack.peek() != y)) {
					stack.add(y);
				}
			}
		}
		
		if(!stack.isEmpty()) {
			count+= stack.size();
		}
		System.out.println(count);
	}

}
