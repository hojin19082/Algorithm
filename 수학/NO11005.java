import java.util.*;
import java.io.*;

public class NO11005 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		while(N>0) {
			if(N%B>=10) {
				System.out.print((char) (N%B-10 + 'A'));
			}else {
				System.out.print((char) (N%B + '0'));
			}
			N = N/B;
		}
	}
	
}
