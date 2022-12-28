import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NO2630 {

	private static int map[][];
	private static int cnt[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		map = new int[N+1][N+1];
		cnt = new int[2];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		quad(1,1,N);
		for(int i=0; i<2; i++) {
			System.out.println(cnt[i]);
		}
	}
	
	public static void quad(int x, int y, int size) {
		int count = 0;
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(map[i][j] == 0) {
					count++;
				}
			}
		}
		if(count==size*size) {
			cnt[0]++;
			return;
		}else if(count==0) {
			cnt[1]++;
			return;
		}else {
			if(size==1) {
				return;
			}
			int newSize = size/2;
			quad(x, y, newSize); // ¿ÞÀ§
			quad(x, y+newSize, newSize); // ¿ÀÀ§
			quad(x+newSize, y, newSize); // ¿Þ¾Æ
			quad(x+newSize, y+newSize, newSize); // ¿À¾Æ
			
		}
	}
}
