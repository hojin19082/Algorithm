package ��Ʈ��ŷ;

import java.util.*;

public class n��°���������ϱ� {

	static ArrayList<Integer> arr;

	public int solution(int[] card, int n) {
		//card �迭�� ��� ���ڵ��� ���� count�迭��
		//��͵��鼭 count�迭���� �ϳ��� ����� used�迭�� �̿��Ͽ�
		//���̰� n�ڸ����� �ɶ����� list�� �־��ֱ�
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
