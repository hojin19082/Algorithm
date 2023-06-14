package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ���ڿ���ȯ {
	//sliding window -> Ư�� ���������� ���� ����
	//�ش� ���������� a�� �����̾�� �ϹǷ�
	//a�� ���� window������ �̿�
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int min = Integer.MAX_VALUE;
		//a�� ������ ���ְ�
		int aCnt = 0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) =='a') {
				aCnt++;
			}
		}
		//0���� �����ؼ� a�� ������ŭ b�� ������ ���ش�
		//���� ���� ���� �ּ� ��ȯ��
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
