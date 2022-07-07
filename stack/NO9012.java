import java.util.*;
import java.io.*;

public class NO9012 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		String ch = "";

		for (int i = 0; i < T; i++) {

			ch = br.readLine();

			System.out.println(solve(ch));
		}
	}

	static public String solve(String ch) {
		ArrayList<Character> arr = new ArrayList<>();

		int top = -1;
		for (int j = 0; j < ch.length(); j++) {
			char c = ch.charAt(j);

			if (c == '(') {
				arr.add(c);
				top++;
			}
			// )¸é •û±â
			else if (c == ')') {
				if (arr.isEmpty()) {
					return "NO";
				} else {
					arr.remove(top);
					top--;
				}
			}
		}
		if (arr.isEmpty()) {
			return "YES";
		} else {
			return "NO";
		}
	}
}
