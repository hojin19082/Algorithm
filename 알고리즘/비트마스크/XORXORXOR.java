package ��Ʈ����ũ;

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
		
		//AND - ���� ��Ʈ�� �Ѵ� 1�̸� 1 �ƴϸ� 0
		System.out.println(A&B);
		//OR - ���� ��Ʈ �� �ϳ��� 1�̸� 1 �ƴϸ� 0
		System.out.println(A|B);
		//XOR - �� ������ �� ��Ʈ�� ���ϸ鼭 ���� ��Ʈ�� ���� �ٸ��� 1 ������ 0
		System.out.println(A^B);
		//NOT - ���� �ϳ��� �� ��Ʈ 1�̸� 0, 0�̸� 1��
		System.out.println(~A);
		//���� int���� �ƴ� binary������ ����ϰ� ������
		System.out.println(Integer.toBinaryString(A));
		
		System.out.println(A);
	}

}
