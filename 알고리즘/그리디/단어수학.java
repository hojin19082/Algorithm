package �׸���;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class �ܾ���� {
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
			//�ش� ���ĺ��� �ڸ����� ���� �־��ְ�
			//�ٸ� �ڸ����� ���� ���ĺ��� ���� �� �����ϱ� ��� �����ֱ�!
			//ex) 10000A �� 100A�� ������ 10100+100�� ���;� ��.
			int temp = (int)Math.pow(10, arr[i].length()-1);
			//temp�� ���� ���ڿ��� �ڸ��� ���� �� ���� �Ѿ������ ������ 10�� �������
			for(int j=0; j<arr[i].length(); j++) {
				alpha[(int)arr[i].charAt(j)-65] += temp;
				temp/=10;
			}
		}
		
		Arrays.sort(alpha);
		int index = 9;
		int sum =0;
		//���� ū �ֺ��� �������鼭 0�� ������ ���� ���� �����Ƿ� break;
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