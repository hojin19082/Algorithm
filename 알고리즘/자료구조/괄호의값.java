package �ڷᱸ��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class ��ȣ�ǰ� {
// ) ] �� ������ ���� value���� ) ]������ ������ ����. �׷��� ) ]�� ������ /2 /3�� ���ִ� ��
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		Stack<Character> stack = new Stack<>();
		int result = 0;
		int value = 1;
		
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			//'('�� *2
			if(ch == '(') {
				stack.push(ch);
				value *=2;
				//'['�� *3
			}else if(ch =='[') {
				stack.push(ch);
				value *=3;
				// ')'�� stack�� ����ְų� ���� ���ð��� (�� �ƴѰ�� 0
			}else if(ch == ')') {
				if(stack.isEmpty() || stack.peek()!='(') {
					result = 0;
					break;
					// ������ �� ������ '('�ε� ���� ���� '('��? �׷��� result�� value���ϱ�
					// ���� ���� �ٸ��Ÿ� ������ �ʰ� �Ѿ
				}else if(str.charAt(i-1) == '(') {
					result += value;
				}
				//stack���� pop�ϰ� )�̴ϱ� value�� /2 �ϸ�
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
