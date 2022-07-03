import java.util.*;
import java.io.*;

public class NO11650 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 람다식을 이용하여 Arrays.sort로 2차원 배열을 정렬할 수 있게 사용자화 한 부분
		Arrays.sort(map, new Comparator<int[]>() {
			@Override
			public int compare(int[] e1, int[] e2) {
				if(e1[0] == e2[0]) {
					return e1[1] - e2[1];
				}
				else {
					return e1[0]-e2[0];
				}
			}
		});
		
		for(int i=0; i<N; i++) {
			System.out.println(map[i][0] + " " + map[i][1]);
		}
	}

}
