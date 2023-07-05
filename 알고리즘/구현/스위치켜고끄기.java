package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스위치켜고끄기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			if (gender == 1) {
				int t = 1;
				int temp = num;
				while (num < N + 1) {
					if (arr[num] == 0)
						arr[num] = 1;
					else
						arr[num] = 0;
					t++;
					num = temp * t;
				}
			} else {
				if (arr[num] == 0)
					arr[num] = 1;
				else
					arr[num] = 0;
				int left = num - 1;
				int right = num + 1;
				while (left > 0 && right <= N && arr[left] == arr[right]) {
					if (arr[left] == 0) {
						arr[left] = 1;
						arr[right] = 1;
					} else {
						arr[left] = 0;
						arr[right] = 0;
					}
					left--;
					right++;
				}

			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(arr[i] + " ");
			if (i % 20 == 0) {
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}

}
