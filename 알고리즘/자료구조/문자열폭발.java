package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 문자열폭발 {
	//stack에 넣고 stack의 크기가 bomb길이 이상일 경우
	//bomb길이만큼 한글자씩 비교
	//하나라도 다른게 생기면 break
	//다 같으면 bomb 길이만큼 pop해주기
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String bomb = br.readLine();
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			stack.push(str.charAt(i));
			if(stack.size() >= bomb.length()) {
				boolean isSame = true;
				for(int j=0; j<bomb.length(); j++) {
					if(stack.get(stack.size()-bomb.length()+j) != bomb.charAt(j)) {
						isSame=false;
						break;
					}
				}
				if(isSame) {
					for(int j=0; j<bomb.length(); j++) {
						stack.pop();
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(char ch : stack) {
			sb.append(ch);
		}
		System.out.println(sb.length()>0 ? sb.toString() : "FRULA");
	}

}
