package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AC {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		ArrayDeque<Integer> deque;
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			deque = new ArrayDeque<>();
			String op = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String numbers = br.readLine();
			numbers = numbers.substring(1,numbers.length()-1);
			String[] number = numbers.split(",");
			for(int j=0; j<n; j++) {
				deque.add(Integer.parseInt(number[j]));
			}
			AC(op, deque);
		}
		System.out.println(sb);
	}
	public static void AC(String op, ArrayDeque<Integer> arr) {

			boolean isRight = true;
			for(int j=0; j<op.length(); j++) {
				char ch = op.charAt(j);
				if(ch == 'R') {
					isRight = !isRight;
					continue;
				}
					
				if(isRight) {
					if(arr.pollFirst() == null) {
						sb.append("error\n");
						return;
					}
				}else {
					if(arr.pollLast() == null) {
						sb.append("error\n");
						return;
				}
					
					
				}
			}
			
			sb.append("[");
			if(arr.size()>0) {
				if(isRight) {
					sb.append(arr.pollFirst());
					while(!arr.isEmpty()) {
						sb.append(',').append(arr.pollFirst());
					}
				}else {
					sb.append(arr.pollLast());
					while(!arr.isEmpty()) {
						sb.append(',').append(arr.pollLast());
					}
				}
			}
			sb.append("]").append("\n");
		}

}
