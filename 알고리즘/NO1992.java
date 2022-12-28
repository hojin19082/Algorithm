import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NO1992 {

	private static int num[][];
	private static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		num = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			String st = br.readLine();
			for(int j=1; j<=N;j++) {
				num[i][j] = st.charAt(j-1) - '0';
			}
		}

		sb = new StringBuilder();
		quadtree(1, N, 1, N, N);
		System.out.println(sb.toString());
	}

	public static void quadtree(int x_start, int x_end, int y_start, int y_end, int size) {
		int count = 0;
		int x_mid = size;
		int y_mid = size;
		for(int i=x_start; i<=x_end; i++) {
			for(int j=y_start; j<=y_end; j++) {
				if(num[i][j] == 0) {
					count++;
				}
			}
		}
		if(count == (size*size)) {
			sb.append('0');
		}else if(count == 0) {
			sb.append('1');
		}else {
			if(x_mid == 1 || y_mid ==1) {
				return;
			}
			x_mid = size/2;
			y_mid = size/2;
			sb.append("(");
			quadtree(x_start, x_start+x_mid-1, y_start, y_start + y_mid -1, size/2); //¿ÞÀ§
			quadtree(x_start, x_start+x_mid-1, y_mid+y_start, y_end, size/2); //¿ÀÀ§
			quadtree(x_start+x_mid, x_end, y_start, y_start + y_mid - 1, size/2); //¿Þ¾Æ
			quadtree(x_start+x_mid, x_end, y_mid+y_start, y_end, size/2); //¿À¾Æ
			sb.append(")");
		}
	}
}
