
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 상어초등학교 {
	static int N, sum;
	static int[][] map;
	static int[] students;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Map<Integer, Set<Integer>> preferences;
	//못푼 이유 -> 자리를 기준으로 하지 않고 map에 현재 자리가 있는 애들을 넣고 
	//현재 자리 근처에 있는 것으로 비교하느라 좋아하는 학생이 몇명인지 알 수 없었음.
	
	//Map에 학생번호와 학생이 좋아하는 학생들 번호들로 구성하여
	//학생마다 앉을 자리를 찾음.
	//비어있는 자리를 기준으로 주변에 좋아하는 학생이 몇명인지 getStudentSum을 통해 알아내고
	//주변에 빈자리가 몇개인지 getEmptySum을 통해 알아낸다.
	//현재 자리와 이전에 찾은 가장 좋은 자리와 비교한다.
	// 1. 주변에 좋아하는 학생이 많은 것이 먼저
	// 2. 1이 같으면 주변에 빈자리가 많은 것이 먼저
	// 3. 2도 같으면 x값 적은 것 / x값도 같으면 y가 적은 것
	//자리를 찾으면 map에 넣고
	//다 넣었으면 각 학생이 주변에 좋아하는 학생이 몇명인지 getStudentSum을 다시 한 번 사용하여
	//구하고 점수 내기
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
			// 범위 벗어나면 skip
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
			// 범위 벗어나면 skip
			if (nx < 1 || nx > N || ny < 1 || ny > N) {
				continue;
			}
			// 빈칸이면 count 증가
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

