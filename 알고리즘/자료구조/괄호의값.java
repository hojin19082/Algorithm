package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 괄호의값 {
// ) ] 에 나오기 전에 value에는 ) ]값까지 더해져 있음. 그래서 ) ]가 나오면 /2 /3을 해주는 것
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		Stack<Character> stack = new Stack<>();
		int result = 0;
		int value = 1;
		
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			//'('면 *2
			if(ch == '(') {
				stack.push(ch);
				value *=2;
				//'['면 *3
			}else if(ch =='[') {
				stack.push(ch);
				value *=3;
				// ')'면 stack이 비어있거나 맨위 스택값이 (가 아닌경우 0
			}else if(ch == ')') {
				if(stack.isEmpty() || stack.peek()!='(') {
					result = 0;
					break;
					// 스택의 맨 위값이 '('인데 이전 값이 '('다? 그러면 result에 value더하기
					// 이전 값이 다른거면 더하지 않고 넘어감
				}else if(str.charAt(i-1) == '(') {
					result += value;
				}
				//stack에서 pop하고 )이니까 value에 /2 하면
				stack.pop();
				value /=2;
			}else if(ch == ']') {
				if(stack.isEmpty() || stack.peek() != '[') {
					result =0;
					break;
				}else if(str.charAt(i-1) == '[') {
					result += value;
				}
				stack.pop();
				value/=3;
			}
		}
		if(!stack.isEmpty()) {
			result = 0;
		}
		System.out.println(result);
	}

}
