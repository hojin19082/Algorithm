package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class �������� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		char lastColor = str.charAt(N-1);
		int red = 0;
		int blue = 0;
		boolean flag = false;
		//���ʿ��� �����ؼ� �� ���� ������ ����
		for(int i=N-2; i>=0; i--) {
			if(lastColor == str.charAt(i) && !flag) continue;
			else {
				flag = true;
				if(str.charAt(i) == 'R') red++;
				else blue++;
			}
		}
		int res1 = Math.min(red, blue);
		red = 0;
		blue = 0;
		flag = false;
		char firstColor = str.charAt(0);
		//�����ʿ��� �����ؼ� �� ���� ������ ����
		for(int i=1; i<N; i++) {
			if(firstColor == str.charAt(i) && !flag) continue;
			else {
				flag = true;
				if(str.charAt(i) == 'R') red++;
				else blue++;
			}
		}
		int res2 = Math.min(red, blue);
		//���ʿ��� ������ ����� �� �� �������� ����.
		System.out.println(Math.min(res1, res2));
	}

}
