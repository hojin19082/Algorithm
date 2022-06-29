import java.io.*;

public class NO10824 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] arr = br.readLine().split(" ");
		
		long num1 = Long.parseLong(arr[0]+arr[1]);
		long num2 = Long.parseLong(arr[2]+arr[3]);
		
		StringBuilder sb = new StringBuilder();
		sb.append(num1 + num2);
		
		System.out.println(sb);
	}

}
