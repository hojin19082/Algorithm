package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 쇠막대기 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> stack = new Stack<>();
		String str = br.readLine();
		char previous = 0;
		int answer = 0;
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(ch == '(') {
				stack.push(String.valueOf(ch));
			}else if(ch == ')' && previous == '(' && stack.peek().equals("(")) {
				stack.pop();
				answer+=stack.size();
			}else if(ch == ')' && previous == ')' && stack.peek().equals("(")) {
				stack.pop();
				answer++;
			}
			previous = ch;	
		}
		System.out.println(answer);
	}

}
