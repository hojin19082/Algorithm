package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class A를B로 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int count = 1;
		while(A < B) {
			if(B%10 == 1) {
				B -= 1;
				B /= 10;
			}else {
				if(B%2 ==0) {
					B /= 2;
				}else {
					break;
				}
			}
			count++;
		}
		if(A !=B) {
			System.out.println(-1);
		}else {
			System.out.println(count);
		}
	}

}
