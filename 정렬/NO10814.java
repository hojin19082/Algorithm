import java.util.*;
import java.io.*;

public class NO10814 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<String>[] arr = new ArrayList[201];
		for(int i=1; i<201; i++) {
			arr[i] = new ArrayList<String>();
		}
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			arr[index].add(st.nextToken());
		}
		
		for(int i=1; i<201; i++) {
			for(int j=0; j<arr[i].size(); j++) {
				System.out.println(i + " " + arr[i].get(j));
			}
		}
	}

}
