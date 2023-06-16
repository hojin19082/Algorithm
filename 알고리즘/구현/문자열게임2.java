package 구현;

import java.io.*;
import java.util.*;

public class 문자열게임2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			Map<Character, ArrayList<Integer>> map = new HashMap<>();
			String w = br.readLine();
			int K = Integer.parseInt(br.readLine());

			for (int i = 0; i < w.length(); i++) {
				if (map.containsKey(w.charAt(i))) {
					map.get(w.charAt(i)).add(i);
				} else {
					map.put(w.charAt(i), new ArrayList<>());
					map.get(w.charAt(i)).add(i);
				}
			}

			int min = Integer.MAX_VALUE;
			int max = 0;
			for (Map.Entry<Character, ArrayList<Integer>> entry : map.entrySet()) {
				
				if (entry.getValue().size() < K)
					continue;

				if (K == 1) {
					min = 1;
					max = 1;
				} else {
					int left = 0;
					int right = 1;
					int index = 0;
					while (index < entry.getValue().size()) {
						if (right == K) {
							min = Math.min(min, entry.getValue().get(index) - entry.getValue().get(left) + 1);
							max = Math.max(max, entry.getValue().get(index) - entry.getValue().get(left) + 1);
							right--;
							left++;
						}
						right++;
						index++;
					}
				}
			}
			
			if (min == Integer.MAX_VALUE || max == 0) {
				sb.append(-1).append("\n");
			} else {
				sb.append(min + " " + max).append("\n");
			}
		}
		System.out.println(sb.toString());

	}

}
