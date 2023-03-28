package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 서로다른부분문자열의개수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		HashSet<String> set = new HashSet<>();
		int count = 1;
		int answer = 1;
		while(count != str.length()) {
			for(int i=0; i<str.length()-count+1; i++) {
				String temp ="";
				if(i == str.length()-count) {
					temp = str.substring(i);
				}else{
					temp = str.substring(i, i+count);
				}
				if(!set.contains(temp)) {
					set.add(temp);
				}
			}
			count++;
		}
		System.out.println(answer + set.size());
	}

}
