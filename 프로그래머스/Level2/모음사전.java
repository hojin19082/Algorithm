package Level2;

public class 모음사전 {

	static StringBuilder sb;
	static int answer = 0;
	static int count = 0;
	static String[] alpha = { "A", "E", "I", "O", "U" };

	public int solution(String word) {
		sb = new StringBuilder();
		dfs(word);
		return answer;
	}

	public static void dfs(String word) {
		if (sb.toString().equals(word)) {
			answer = count;
		}

		if (sb.length() == 5) {
			return;
		}

		for (int i = 0; i < 5; i++) {
			sb.append(alpha[i]);
			count++;
			dfs(word);
			sb.deleteCharAt(sb.length() - 1);
		}

	}
}
