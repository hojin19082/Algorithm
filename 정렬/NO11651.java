import java.util.*;
import java.io.*;

public class NO11651 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][2];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][0] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, (e1,e2)-> {
				if (e1[0] == e2[0]) {
					return e1[1] - e2[1];
				} else {
					return e1[0] - e2[0];
				}
		});
		
		for (int i = 0; i < N; i++) {
			System.out.println(arr[i][1] + " " + arr[i][0]);
		}
	}

}
