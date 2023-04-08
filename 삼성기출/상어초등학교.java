
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class ����ʵ��б� {
	static int N, sum;
	static int[][] map;
	static int[] students;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Map<Integer, Set<Integer>> preferences;
	//��Ǭ ���� -> �ڸ��� �������� ���� �ʰ� map�� ���� �ڸ��� �ִ� �ֵ��� �ְ� 
	//���� �ڸ� ��ó�� �ִ� ������ ���ϴ��� �����ϴ� �л��� ������� �� �� ������.
	
	//Map�� �л���ȣ�� �л��� �����ϴ� �л��� ��ȣ��� �����Ͽ�
	//�л����� ���� �ڸ��� ã��.
	//����ִ� �ڸ��� �������� �ֺ��� �����ϴ� �л��� ������� getStudentSum�� ���� �˾Ƴ���
	//�ֺ��� ���ڸ��� ����� getEmptySum�� ���� �˾Ƴ���.
	//���� �ڸ��� ������ ã�� ���� ���� �ڸ��� ���Ѵ�.
	// 1. �ֺ��� �����ϴ� �л��� ���� ���� ����
	// 2. 1�� ������ �ֺ��� ���ڸ��� ���� ���� ����
	// 3. 2�� ������ x�� ���� �� / x���� ������ y�� ���� ��
	//�ڸ��� ã���� map�� �ְ�
	//�� �־����� �� �л��� �ֺ��� �����ϴ� �л��� ������� getStudentSum�� �ٽ� �� �� ����Ͽ�
	//���ϰ� ���� ����
	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		students= new int[(N*N)+1];
		preferences= new HashMap<>();
		
		for(int i=1; i<=N*N; i++) {
			st = new StringTokenizer(br.readLine());
			int student = Integer.parseInt(st.nextToken());
			students[i] = student;
			preferences.put(student, new HashSet<>());
			for(int j=0; j<4; j++) {
				preferences.get(student).add(Integer.parseInt(st.nextToken()));
			}
		}
		
		for(int i=1; i<students.length; i++) {
			Seat seat = findSeat(students[i]);
			map[seat.x][seat.y] = students[i];
		}
		
		int answer = 0;
		for(int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				int count = getStudentSum(i, j, map[i][j]);
				if(count > 0) {
					answer += Math.pow(10, count-1);
				}
			}
		}
		System.out.println(answer);
	}
	public static Seat findSeat(int student) {
		Seat seat = null;
		for(int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				if(map[i][j] >0) continue;
				Seat cur = new Seat(i,j,getStudentSum(i,j,student), getEmptySum(i,j));
				
				if(seat == null) {
					seat = cur;
					continue;
				}
				
				if(seat.compareTo(cur) > 0) {
					seat = cur;
				}
			}
		}
		return seat;
	}
	public static int getStudentSum(int x, int y, int student) {
		int count = 0;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			// ���� ����� skip
			if (nx < 1 || nx > N || ny < 1 || ny > N) {
				continue;
			}
			if(preferences.get(student).contains(map[nx][ny])) {
				count++;
			}
		}
		return count;
	}
	public static int getEmptySum(int x, int y) {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			// ���� ����� skip
			if (nx < 1 || nx > N || ny < 1 || ny > N) {
				continue;
			}
			// ��ĭ�̸� count ����
			if (map[nx][ny] == 0) {
				count++;
			}
		}
		return count;
	}
	
	static class Seat implements Comparable<Seat>{
		int x, y, studentSum, emptySum;
		
		public Seat(int x, int y, int studentSum, int emptySum) {
			this.x = x;
			this.y = y;
			this.studentSum = studentSum;
			this.emptySum = emptySum;
		}
		
		@Override
		public int compareTo(Seat o) {
			
			if(studentSum != o.studentSum) {
				return -(studentSum - o.studentSum);
			}
			if(emptySum != o.emptySum) {
				return -(emptySum - o.emptySum);
			}
			if(x != o.x) {
				return x - o.x;
			}
			return y - o.y;
		}
	}
}

