package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 주식 {
	//answer를 구할 때 int로 할 경우 32bit의 값만 표현할 수 있지만,
	//문제에서는 64bit의 정수로 나타낼 수 있음. 따라서 int형이 아닌 long형으로 구현!
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Deque<Integer> queue;
		TreeMap<Integer, Integer> list;
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			queue = new LinkedList<>();
			list = new TreeMap<>();
			
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				list.put(arr[i], list.getOrDefault(arr[i], 0)+1);
			}
			
			int max = list.lastKey();
			long answer = 0;
			queue.add(arr[0]);
			for (int i = 1; i < N; i++) {
				if (queue.isEmpty() || queue.peekLast() < max) {
					queue.add(arr[i]);
				} else {
					answer += queueCal(queue, list);
					queue.add(arr[i]);
					if(!list.isEmpty()) {
						max = list.lastKey();
					}	
				}
			}
			if (!queue.isEmpty()) {
				answer += queueCal(queue, list);
			}
			sb.append(answer + "\n");
		}
		System.out.println(sb.toString());
	}

	
	public static long queueCal(Deque<Integer> queue, TreeMap<Integer, Integer> list) {
		int cnt = 0;
		long result = 0;
		while (!queue.isEmpty()) {
			int num = queue.pollFirst();
			
			if (queue.size() == 0) {
				result += (long) (num * cnt);
			} else {
				cnt++;
				result -= (long) num;
			}
			
			if(list.containsKey(num)) {
				if(list.get(num) == 1) {
					list.remove(num);
				}else {
					list.put(num, list.get(num)-1);
				}
			}
		}
		return result;
	}

}
