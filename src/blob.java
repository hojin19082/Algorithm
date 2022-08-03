import java.io.*;
import java.util.*;
public class blob {
	private static int N=8;
	private static int [][] blob = {
			{1,0,0,0,0,0,0,1},
			{0,1,1,0,0,1,0,0},
			{1,1,0,0,1,0,1,1},
			{0,0,0,0,0,1,0,0},
			{0,1,0,1,0,0,1,1},
			{0,1,0,1,0,1,0,1},
			{1,0,0,0,1,0,0,1},
			{0,1,1,0,0,1,1,1}
	};
	private static final int back=0;
	private static final int image = 1;
	private static final int counted = 2;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		System.out.println(blobcount(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
	}
	public static int blobcount(int x, int y) {
		if(x<0 || x>=N || y<0 || y>=N) {
			return 0;
		}else if(blob[x][y] != image) {
			return 0;
		}else {
			blob[x][y] = counted;
			return 1+blobcount(x, y+1)+blobcount(x+1,y+1)
			+blobcount(x+1, y) + blobcount(x+1, y-1) +
			blobcount(x, y-1) + blobcount(x-1, y-1) +
			blobcount(x-1, y) + blobcount(x-1, y+1);
			
		}
	}
}
