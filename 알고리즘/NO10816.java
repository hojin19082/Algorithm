import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class NO10816 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			map.put(tmp, map.getOrDefault(tmp, 0)+1);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			sb.append(map.getOrDefault(tmp, 0)+" ");
		}
		System.out.println(sb.toString());
	}

}
