package 구현;

import java.io.*;
import java.util.*;

public class 회전초밥 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] rice = new int[N];
		for (int i = 0; i < N; i++) {
			rice[i] = Integer.parseInt(br.readLine());
		}
		int answer = 0;
		for (int i = 0; i < N; i++) {
			int[] temp = new int[k];
			int cnt = 0;
			
			while (cnt != k) {
				temp[cnt] = rice[(i + cnt) % N];
				cnt++;
			}
			
			boolean[] check = new boolean[d+1];
			int count = 0;
			
			for (int j = 0; j < k; j++) {
				if (!check[temp[j]]) {
					count++;
					check[temp[j]] = true;
				}
			}
			
			if (!check[c]) {
				count++;
			}
			
			answer = Math.max(answer, count);
		}
		System.out.println(answer);
	}

}
