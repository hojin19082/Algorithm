package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

public class 영단어암기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if (str.length() >= M) {
				map.put(str, map.getOrDefault(str, 0) + 1);
			}
		}
		//map의 key가 아닌 value로 정렬하기 위해 list안에 map.entry로 뽑아내기
		List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
		entryList.sort((o1, o2) -> {
			//나머진 더 길거나 더 값이 클 경우이므로 o2부터
			if (map.get(o2.getKey()) == map.get(o1.getKey())) {
				if (o2.getKey().length() == o1.getKey().length()) {
					//알파벳 사전순이기 때문에 o1으로 o2비교!
					return o1.getKey().compareTo(o2.getKey());
				} else {
					return o2.getKey().length() - o1.getKey().length();
				}
			} else {
				return map.get(o2.getKey()) - map.get(o1.getKey());
			}
		});

		StringBuilder sb = new StringBuilder();
		for(Map.Entry<String, Integer> entry : entryList) {
			sb.append(entry.getKey() + "\n");
		}
		System.out.println(sb.toString());
	}
}
