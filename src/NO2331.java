import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class NO2331 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Stack<String> stack = new Stack<>();
		
		String A = st.nextToken();
		int p = Integer.parseInt(st.nextToken());
		int j=0;
		while (j!=1) {
			stack.push(A);
			int result = 0;
			
			for (int i = 0; i < A.length(); i++) {
				int num = A.charAt(i) - '0';
				result = (int) (result + Math.pow(num, p));
			}
			A = Integer.toString(result);
			
			for(int i=0; i<stack.size(); i++) {
				if(stack.get(i).equals(A)) {
					System.out.println(i);
					j=1;
				}
			}
		}
	}
}
