package �׸���;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class �������� {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long num = Long.parseLong(br.readLine());
		
		int count = 0;
		while(num - count > 0) {
			count++;
			num-=count;
		}
		System.out.println(count);
	}

}
