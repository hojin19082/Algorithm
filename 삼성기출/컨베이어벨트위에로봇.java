import java.io.*;
import java.util.*;

public class 컨베이어벨트위에로봇 {
	static int N, K;
	static int[] arr;
	static int[] robotArr;
	static TreeMap<Integer, Integer> robotList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[(2 * N) + 1];
		robotArr = new int[(2 * N) + 1];
		robotList = new TreeMap<>();
		for (int i = 1; i <= 2 * N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int time = 1;
		int robotCount = 1;
		while (true) {
			// 벨트 이동
			moveBelt();

			// 로봇 이동
			moveRobot();
			
			// 로봇 올리기
			if (arr[1] != 0) {
				// 로봇 올리고 내구도 감소
				robotList.put(robotCount, 1);
				robotArr[1] = robotCount;
				robotCount++;
				arr[1]--;
			}
			// 만약 내구도가 0인 칸의 개수가 K개 이상이면 과정 종료
			int count = 0;
			for (int i = 1; i <= 2 * N; i++) {
				if (arr[i] == 0)
					count++;
			}

			if (count >= K)
				break;
			time++;
		}
		System.out.println(time);
	}

	public static void moveRobot() {
		TreeMap<Integer, Integer> temp = (TreeMap<Integer, Integer>) robotList.clone();
		for (Integer r : temp.keySet()) {
			// 만약 다음 칸으로 갈 수 있으면
			if(!robotList.containsKey(r)) continue;
			int robotPosition = robotList.get(r);
			if (robotPosition == 2 * N) {
				if (robotArr[1] == 0 && arr[1] >= 1) {
					robotList.put(r, 1);
					robotArr[2 * N] = 0;
					robotArr[1] = r;
					arr[1]--;
				}
			} else {
				if (robotArr[robotPosition + 1] == 0 && arr[robotPosition + 1] >= 1) {
					// 기존 자리 로봇 개수 줄이고
					robotArr[robotPosition] = 0;
					robotPosition++;
					robotList.put(r, robotPosition);
					// 다음 칸 이동
					robotArr[robotPosition] = r;
					// 내구도 감소
					arr[robotPosition]--;

					// 로봇이 움직여서 내리는 위치에 도달하면 바로 없애기
					if (robotPosition == N) {
						robotList.remove(r);
						robotArr[N] = 0;
					}
				}
			}
		}
	}

	public static void moveBelt() {
		int[] temp = Arrays.copyOf(arr, (2 * N) + 1);
		int[] robotTemp = Arrays.copyOf(robotArr, (2 * N) + 1);
		for (int i = 1; i <= 2 * N; i++) {
			if (i == 2 * N) {
				arr[1] = temp[2 * N];
				robotArr[1] = robotTemp[2 * N];
				if (robotList.containsKey(robotTemp[2 * N])) {
					robotList.put(robotTemp[2 * N], 1);
				}
			} else {
				arr[i + 1] = temp[i];
				robotArr[i + 1] = robotTemp[i];
				if(i+1 == N) {
					robotArr[i + 1] = 0;
					robotList.remove(robotTemp[i]);
				}
				
				if (robotList.containsKey(robotTemp[i])) {
					robotList.put(robotTemp[i], i + 1);
				}

			}
		}
	}
}
