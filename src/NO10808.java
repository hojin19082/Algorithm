import java.util.*;
import java.io.*;

public class NO10808 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] cnt = new int[26];
		for(int i=0; i<26; i++) {
			cnt[i] = 0;
		}
		
		String st = br.readLine();
		for(int i=0; i<st.length(); i++) {
			int ch = st.charAt(i)-'a';
			cnt[ch]++;
		}
		for(int i=0; i<26; i++) {
			System.out.print(cnt[i] +" ");
		}
	}

}
