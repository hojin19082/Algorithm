import java.io.*;

public class NO10872 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N == 0 || N == 1) {
			System.out.println(1);
		} else {

			int sum = 1;

			for (int i = 2; i <= N; i++) {
				sum *= i;
			}

			System.out.println(sum);
		}
	}

}
