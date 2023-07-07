package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수이어쓰기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int pt = 0;
		int base = 1;
		
		while(true) {
			String st = String.valueOf(base);
			for(int i=0; i<st.length(); i++) {
				if(st.charAt(i) == str.charAt(pt)) {
					pt++;
				}
				
				if(pt == str.length()) {
					System.out.println(base);
					return;
				}
			}
			base++;
		}
	}

}
