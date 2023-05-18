package Level2;

import java.util.*;

public class 과제진행하기 {
	public String[] solution(String[][] plans) {
		String[] answer = new String[plans.length];
		Stack<String> stack = new Stack<>();
		Map<String, Integer> map = new HashMap<>();
		Arrays.sort(plans, (o1, o2) -> {
			int temp1 = convert(o1[1]);
			int temp2 = convert(o2[1]);
			return temp1 - temp2;
		});

		for (int i = 0; i < plans.length; i++) {
			map.put(plans[i][0], Integer.parseInt(plans[i][2]));
		}

		String working = plans[0][0];
		int start = convert(plans[0][1]);
		int end = Integer.parseInt(plans[0][2]);
		int k = 0;
		for (int i = 1; i < plans.length; i++) {
			int temp = convert(plans[i][1]);
			if (temp - start < end) {
				stack.add(working);
				map.put(working, map.get(working) - (temp - start));
			} else {
				answer[k++] = working;
				start += end;
				while (!stack.isEmpty() && (start < temp)) {
					working = stack.pop();
					int rest = map.get(working);
					if (rest > temp - start) {
						stack.add(working);
						map.put(working, rest - (temp - start));
						start += temp - start;
					} else {
						answer[k++] = working;
						start += rest;
					}
				}
			}
			working = plans[i][0];
			start = temp;
			end = Integer.parseInt(plans[i][2]);
		}
		answer[k++] = working;
		while (!stack.isEmpty()) {
			answer[k++] = stack.pop();
		}
		return answer;
	}

	public static int convert(String time) {
		String[] str = time.split(":");
		return Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
	}
}
