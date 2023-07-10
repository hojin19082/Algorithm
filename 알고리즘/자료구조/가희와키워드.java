package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 가희와키워드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			map.put(str, 1);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			String[] strList = str.split(",");
			for(int j=0; j<strList.length; j++) {
				if(map.containsKey(strList[j])) {
					map.remove(strList[j]);
				}
			}
			sb.append(map.size()+"\n");
		}
		System.out.println(sb.toString());
	}

}
