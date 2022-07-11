import java.util.*;
import java.io.*;

public class NO11004 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		ArrayList<Integer> arr = new ArrayList<>();
	    
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
		{
			arr.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(arr);
		
		System.out.println(arr.get(k-1));
	}
}
