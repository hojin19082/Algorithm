package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열교환 {
	//sliding window -> 특정 개수까지만 보는 전략
	//해당 문제에서는 a가 연속이어야 하므로
	//a의 개수 window값으로 이용
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int min = Integer.MAX_VALUE;
		//a의 개수를 세주고
		int aCnt = 0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) =='a') {
				aCnt++;
			}
		}
		//0부터 시작해서 a의 개수만큼 b의 개수를 세준다
		//가장 작은 값이 최소 교환값
		for(int i=0; i<str.length(); i++) {
			int bCnt = 0;
			for(int j=i; j<i+aCnt; j++) {
				int idx = j%str.length();
				if(str.charAt(idx) =='b') {
					bCnt++;
				}
			}
			min = Math.min(min, bCnt);
		}
		System.out.println(min);
	}

}
