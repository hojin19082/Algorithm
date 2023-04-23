package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬만들기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		if(str.length()==1) {
			System.out.println(str);
			return;
		}
		char[] answer = new char[str.length()];
		int[] alphabet = new int[26];
		for(int i=0; i<str.length(); i++) {
			alphabet[str.charAt(i)-'A']++;
		}
		int count = 0;
		int mid = 0;
		for(int i=0; i<26; i++) {
			if(alphabet[i] %2 == 1) {
				mid = i;
				count++;
			}
		}
		if(count >1) System.out.println("I'm Sorry Hansoo");
		else {
			if(count == 1) {
				answer[str.length()/2] = (char)('A' + mid);
			}
			for(int i=0; i<str.length()/2; i++) {
				for(int j=0; j<26; j++) {
					if(alphabet[j] >= 2) {
						answer[i] = answer[str.length()-1-i] =(char)('A' + j);
						alphabet[j]-=2;
						break;
					}
				}
			}
			System.out.println(answer);
		}
		
	}

}
