package 구현;

public class 소용돌이수 {

	public int solution(int n) {
		int[][] map = new int[n][n];
		int dir = 0;
		int num = 1;
		int i = 0, j = 0;
		while (true) {
			map[i][j] = num;
			if (dir == 0 && (j == n - 1 || (j < n - 1 && map[i][j + 1] != 0)))
				dir++;
			else if (dir == 1 && (i == n - 1 || (i < n - 1 && map[i + 1][j] != 0)))
				dir++;
			else if (dir == 2 && (j == 0 || (j > 0 && map[i][j - 1] != 0)))
				dir++;
			else if (dir == 3 && (i == 0 || (i > 0 && map[i - 1][j] != 0)))
				dir = 0;

			if (dir == 0)
				j++;
			else if (dir == 1)
				i++;
			else if (dir == 2)
				j--;
			else if (dir == 3)
				i--;
			if (num == (int) Math.pow(n, 2))
				break;
			num++;
		}

		int answer = 0;
		for (int k = 0; k < n; k++) {
			answer += map[k][k];
		}
		return answer;
	}

}
