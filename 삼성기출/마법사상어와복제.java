import java.io.*;
import java.util.*;

public class ��������ͺ��� {

	static class Fish implements Cloneable {
		int x;
		int y;
		int d;

		public Fish(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		protected Fish clone() throws CloneNotSupportedException { // Ŭ���� ����
			return (Fish) super.clone();
		}

	}

	static int M, S;
	static int fdx[] = { 0, 0, -1, -1, -1, 0, 1, 1, 1 }; // ����� �̵�
	static int fdy[] = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };

	static int dx[] = { 0, -1, 0, 1, 0 }; // ��� �̵�
	static int dy[] = { 0, 0, -1, 0, 1 };

	static ArrayList<Fish> map[][];
	static ArrayList<Fish> list;
	static int smell[][]; // ����� ����
	static int sx, sy; // ��� ��ġ

	static int res; // ���ڿ� �ִ� ����� ��(����)

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // ����� ��
		S = Integer.parseInt(st.nextToken()); // ���� ���� Ƚ��

		// ����� ����
		smell = new int[4][4];
		// map ����
		map = new ArrayList[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++)
				map[i][j] = new ArrayList<Fish>();
		}
		list = new ArrayList<Fish>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());

			list.add(new Fish(r, c, d));

		}
		
		// ��� ��ġ �Է�
		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken()) - 1;
		sy = Integer.parseInt(st.nextToken()) - 1;

		simulation();
		System.out.println(res);

	}

	private static void simulation() throws CloneNotSupportedException {
		for (int time = 0; time < S; time++) {
			// 1. ����� ���� ����
			ArrayList<Fish> copy = copy(list);
			
			// 2. ����� �̵�
			for (int i = 0; i < list.size(); i++) {
				Fish cur = list.get(i);
				cur = moveFish(cur);
			}
			// 2-1. ����� �̵��� �� map�� ��ġ
			setMap();
			
			// 3. ��� ���� �̵�(��Ʈ��ŷ)
			fishNum = Integer.MIN_VALUE; // �ش� �������� �� �� �Դ� ����� �� �ʱ�ȭ
			sharkBacktracking(0); // ���� ���� �԰�, ���������� ���� ���� ã�� by �ߺ�����
			sharkMove();
			
			// 4. ����� ���� ���ڿ��� �����
			smellRemove();
			
			// 5. �������� map�� ó��
			setCopyMap(copy);
			
			// 6. map�� �ִ� ���� list�� ���(����� ������ ����)
			reset();

		}
	}

	private static void sharkMove() { // sharkBacktracking���� ���� ���� �������� �̵��ϸ� ����� ���� ���̱� + ����� ���� �����

		for (int i = 0; i < 3; i++) {
			sx += dx[shkMove[i]];
			sy += dy[shkMove[i]];
			if (map[sx][sy].size() > 0) {
				smell[sx][sy] = 3;
				map[sx][sy].clear();
			}

		}

	}

	private static void reset() { // ���� ���� ���� map�� ������ list�� �����ϰ�, map ����
		list.clear(); // ���� list Ŭ����
		int cnt = 0; // ����� ����
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < map[i][j].size(); k++) {
					Fish cur = map[i][j].get(k);
					list.add(cur);
					cnt++;
				}
				map[i][j].clear();
			}
		}
		res = cnt; // ���� ����
	}

	private static void setCopyMap(ArrayList<Fish> copy) { // 1������ ������ �������� map�� �����Ű��
		for (int i = 0; i < copy.size(); i++) {
			Fish cur = copy.get(i);
			map[cur.x][cur.y].add(cur);
		}

	}

	private static void smellRemove() { // ����� ���� ����� 
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (smell[i][j] > 0) // ������ �������� ���
					smell[i][j]--;
			}
		}

	}

	static int result[] = new int[3]; // ��� �̵� ����(�ӽ�)
	static int shkMove[] = new int[3]; // ��� �̵� ����(����)
	static int fishNum = Integer.MIN_VALUE;

	private static void sharkBacktracking(int idx) { // ��� �̵����� ���ϱ� by �ߺ�����
		if (idx == 3) {
			int fnum = checkFish(); // �ش� �������� �� �̵����� �� ����� ��
			if(fnum==-1) // �� ���� ����
				return;
			if (fishNum < fnum) {
				fishNum = fnum;
				for (int i = 0; i < 3; i++) {
					shkMove[i] = result[i];
				}
			}
			return;
		}

		for (int i = 1; i <= 4; i++) { // 1~4���� �ߺ�����
			result[idx] = i;
			sharkBacktracking(idx + 1);
		}

	}

	private static int checkFish() { // sharkBacktracking���� ���� �������� ���� �� �Դ� ����� ��
		boolean visited[][] = new boolean[4][4];
		int cnt = 0; // ����� ��
		int nx = sx, ny = sy;
		for (int i = 0; i < 3; i++) {
			nx += dx[result[i]];
			ny += dy[result[i]];

			if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) {
				cnt = 0;
				cnt = -1; // ���� ���
				break;
			}
			if (visited[nx][ny]) // �̹� �湮�� �����̸� ����� �� å�� x
				continue;
			cnt += map[nx][ny].size();
			visited[nx][ny] = true;
		}
		return cnt;

	}

	private static void setMap() {
		for (int i = 0; i < list.size(); i++) {
			Fish cur = list.get(i);
			map[cur.x][cur.y].add(cur);
		}
	}

	private static Fish moveFish(Fish cur) {
		int nx = 0, ny = 0;
		int cnt = 0;
		while (true) {
			nx = cur.x + fdx[cur.d];
			ny = cur.y + fdy[cur.d];
			if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && // ���� ���̰�, ����� ���� x�̰�, ��� ��ġ �ƴϸ�
					smell[nx][ny] == 0 && !(nx == sx && ny == sy))
				break;
			cur.d = cur.d - 1; // �ݽð� 45�� ȸ��
			if (cur.d <= 0)
				cur.d = 8;
			cnt++;
			if (cnt == 8) // 8���� �� ������ ��� -> �� �� x
				break;
		}
		if (cnt < 8) {
			cur.x = nx;
			cur.y = ny;
		}

		return cur;
	}

	private static ArrayList<Fish> copy(ArrayList<Fish> list) throws CloneNotSupportedException { // ����Ʈ ����
		ArrayList<Fish> tmp = new ArrayList<Fish>();
		for (int i = 0; i < list.size(); i++) {
			Fish cur = list.get(i);
			tmp.add(cur.clone());
		}
		return tmp;
	}
}