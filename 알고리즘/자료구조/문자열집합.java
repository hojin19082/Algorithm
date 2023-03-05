package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 문자열집합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, Integer> map = new HashMap<>();
		for(int i=0; i<N; i++) {
			map.put(br.readLine(), i);
		}
		int count = 0;
		for(int i=0; i<M; i++) {
			if(map.containsKey(br.readLine())) {
				count++;
			}
		}
		System.out.println(count);
	}
}
