package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 단어수학 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		int[] alpha = new int[26];
		
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}
		
		for(int i=0; i<N; i++) {
			//해당 알파벳의 자리수의 값을 넣어주고
			//다른 자리에서 같은 알파벳이 나올 수 있으니까 계속 더해주기!
			//ex) 10000A 후 100A가 나오면 10100+100가 나와야 함.
			int temp = (int)Math.pow(10, arr[i].length()-1);
			//temp는 현재 문자열의 자리수 부터 한 글자 넘어갈때마다 나누기 10씩 해줘야함
			for(int j=0; j<arr[i].length(); j++) {
				alpha[(int)arr[i].charAt(j)-65] += temp;
				temp/=10;
			}
		}
		
		Arrays.sort(alpha);
		int index = 9;
		int sum =0;
		//가장 큰 애부터 내려가면서 0을 만나면 이제 값이 없으므로 break;
		for(int i=alpha.length-1; i>=0; i--) {
			if(alpha[i] == 0) {
				break;
			}
			sum+=alpha[i]*index;
			index--;
		}
		System.out.println(sum);
	}
}