import java.io.*;
import java.util.*;
public class NO11576 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		
		Stack<Integer> result = new Stack<>();
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		for(int i=0; i<m; i++) {
			sum = sum + (int) (Integer.parseInt(st.nextToken()) * Math.pow(A, m-i-1));
		}
		
		while(sum!=0) {
			result.push(sum%B);
			sum /= B;
		}
		int resultSize = result.size();
		for(int i=0; i<resultSize; i++) {
			if(i == resultSize-1) {
				System.out.print(result.pop());
			}else {
				System.out.print(result.pop() + " ");
			}
		}
	}
}
