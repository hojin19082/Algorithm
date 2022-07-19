
import java.io.*;

public class NO11653 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 2; i <= Math.sqrt(N); i++) {
			while(N % i == 0) {
				System.out.println(i);
				N /= i;
			}
		}
		if(N!=1) {
			System.out.println(N);
		}
	}
}
