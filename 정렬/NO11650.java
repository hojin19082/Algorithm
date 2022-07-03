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
		
		// ���ٽ��� �̿��Ͽ� Arrays.sort�� 2���� �迭�� ������ �� �ְ� �����ȭ �� �κ�
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
