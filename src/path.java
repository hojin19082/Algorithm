import java.util.*;
import java.io.*;
public class path {
	public static int arr[][];
	public static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		StringTokenizer st;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		 for (int k = 0; k < N; k++) {
	            for (int i = 0; i < N; i++) {
	                for (int j = 0; j < N; j++) {
	                    if (arr[i][k] == 1 && arr[k][j] == 1) {
	                        arr[i][j] = 1;
	                    }
	                }
	            }
		 }
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
