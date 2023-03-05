package 자료구조;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class 후위표기식 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<str.length(); i++) {
        	char now = str.charAt(i);
        	if(now == '+' || now == '-' || now =='*' || now == '/') {
        		while(!stack.isEmpty() && priority(stack.peek()) >= priority(now)) {
        			sb.append(stack.pop());
        		}
        		stack.add(now);
        	} else if(now == '(') {
    			stack.add(now);
    		} else if(now == ')') {
    			while(!stack.isEmpty() && stack.peek() != '('){
    				sb.append(stack.pop());
    			}
    			stack.pop();
    		}else {
    			sb.append(now);
    		}
        }
        while(!stack.isEmpty()) {
        	sb.append(stack.pop());
        }
        System.out.println(sb);
	}
	public static int priority(char op) {
		if(op == '(' || op == ')') {
			return 0;
		}else if( op == '+' || op == '-') {
			return 1;
		}else if (op == '*' || op == '/') {
			return 2;
		}
		return -1;
	}

}
