package 비트마스크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class XORXORXOR {

	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		for(int i=0; i<C; i++) {
			A = A^B;
		}
		
		//AND - 양쪽 비트가 둘다 1이면 1 아니면 0
		System.out.println(A&B);
		//OR - 양쪽 비트 중 하나라도 1이면 1 아니면 0
		System.out.println(A|B);
		//XOR - 두 정수를 한 비트씩 비교하면서 양쪽 비트가 서로 다르면 1 같으면 0
		System.out.println(A^B);
		//NOT - 정수 하나의 각 비트 1이면 0, 0이면 1로
		System.out.println(~A);
		//만약 int형이 아닌 binary형으로 출력하고 싶으면
		System.out.println(Integer.toBinaryString(A));
		
		System.out.println(A);
	}

}
