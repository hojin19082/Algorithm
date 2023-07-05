package �ڷᱸ��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

public class ���ܾ�ϱ� {

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
		//map�� key�� �ƴ� value�� �����ϱ� ���� list�ȿ� map.entry�� �̾Ƴ���
		List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
		entryList.sort((o1, o2) -> {
			//������ �� ��ų� �� ���� Ŭ ����̹Ƿ� o2����
			if (map.get(o2.getKey()) == map.get(o1.getKey())) {
				if (o2.getKey().length() == o1.getKey().length()) {
					//���ĺ� �������̱� ������ o1���� o2��!
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
