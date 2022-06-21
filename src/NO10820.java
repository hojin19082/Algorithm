import java.util.*;
import java.io.*;

public class NO10820 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String st = "";
		while ((st = br.readLine()) != null) {
			int[] cnt = new int[4];
			for (int i = 0; i < st.length(); i++) {
				char ch = (char) st.charAt(i);
				if (ch >= 'a' && ch <= 'z') {
					cnt[0]++;
				} else if (ch >= 'A' && ch <= 'Z') {
					cnt[1]++;
				} else if (ch >= '0' && ch <= '9') {
					cnt[2]++;
				} else {
					cnt[3]++;
				}
			}
			for (int j = 0; j < 4; j++) {
				System.out.print(cnt[j] + " ");
			}
		}
	}
}
