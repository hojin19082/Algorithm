package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 비슷한단어 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String start = br.readLine();
		int[] alphabet = new int[26];
		for (int i = 0; i < start.length(); i++) {
			alphabet[start.charAt(i) - 'A']++;

		}

		int count = 0;
		for (int i = 0; i < N - 1; i++) {
			int[] compare = alphabet.clone();
			String str = br.readLine();
			int cnt = 0;
			for (int j = 0; j < str.length(); j++) {
				if (compare[str.charAt(j) - 'A'] >0) {
					cnt++;
				}
				compare[str.charAt(j) - 'A']--;
			}
			
			if(start.length()-1 == str.length() && cnt == str.length()) {
				count++;
			}else if(start.length() == str.length()) {
				if(cnt == start.length() || cnt == start.length()-1) count++;
			}else if(start.length() +1 == str.length()) {
				if(cnt == start.length()) count++;
			}
		}

		System.out.println(count);
	}

}
