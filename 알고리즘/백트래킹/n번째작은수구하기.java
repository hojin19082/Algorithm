package 백트래킹;

import java.util.*;

public class n번째작은수구하기 {

	static ArrayList<Integer> arr;

	public int solution(int[] card, int n) {
		//card 배열에 담긴 숫자들을 담은 count배열과
		//재귀돌면서 count배열에서 하나씩 사용한 used배열을 이용하여
		//길이가 n자리수가 될때마다 list에 넣어주기
		int answer = 0;
		arr = new ArrayList<>();
		int[] cardCnt = new int[10];
		int[] usedCnt = new int[10];
		for (int i = 0; i < card.length; i++) {
			cardCnt[card[i]]++;
		}

		dfs(cardCnt, usedCnt, card.length, 0);

		Collections.sort(arr);
		for (int i = 0; i < arr.size(); i++) {
			if (n == arr.get(i)) {
				answer = i + 1;
			}
		}
		if (answer == 0)
			answer = -1;

		return answer;
	}

	public static void dfs(int[] cardCnt, int[] usedCnt, int length, int num) {
		if (length == 0) {
			arr.add(num);
			return;
		}
		for (int i = 1; i < 10; i++) {
			if (usedCnt[i] < cardCnt[i]) {
				usedCnt[i]++;
				dfs(cardCnt, usedCnt, length - 1, num * 10 + i);
				usedCnt[i]--;
			}
		}

	}
}
