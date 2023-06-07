package 삼성기출;

import java.io.*;
import java.util.*;
public class 청소년상어 {
	static int[] dx = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static class Fish {
		int x, y, dir;

		Fish(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
	static List<Integer> answer = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[4][4];
		StringTokenizer st;
		TreeMap<Integer, Fish> fish = new TreeMap<>();
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 8; j++) {
				if (j % 2 == 1) {
					fish.put(map[i][j / 2], new Fish(i, j / 2, Integer.parseInt(st.nextToken())));
				} else {
					map[i][j / 2] = Integer.parseInt(st.nextToken());
				}
			}
		}
		int sharkX = 0;
		int sharkY = 0;
		int sharkEat = map[0][0];
		int sharkDir = fish.get(map[0][0]).dir;
		fish.remove(map[0][0]);
		map[0][0] = 0;
		//위에서 먼저 상어를 0,0으로 움직였으니까
		//sharkMove는 바로 물고기 이동부터 시작
		sharkMove(map, sharkX, sharkY, sharkDir, sharkEat, fish);
		Collections.sort(answer,Collections.reverseOrder());
		System.out.println(answer.get(0));
	}

	public static ArrayList<Fish> checkMove(int[][] temp, int x, int y, int dir, TreeMap<Integer, Fish> fish) {
		ArrayList<Fish> arr = new ArrayList<>();
		int nx = x;
		int ny = y;
		//현재 상어의 방향으로 갈 수 있을 때까지 가면서 물고기가 있으면 list에 저장
		while (true) {
			nx += dx[dir];
			ny += dy[dir];
			if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4) {
				break;
			}
			if (temp[nx][ny] > 0) {
				arr.add(new Fish(nx, ny, fish.get(temp[nx][ny]).dir));
			}
		}
		return arr;
	}

	public static void sharkMove(int[][] map, int sx, int sy, int sdir, int result, TreeMap<Integer, Fish> tempFish) {
		ArrayList<Fish> arr = new ArrayList<>();
		// 물고기 이동
		moveFish(map, tempFish, sx, sy);
		// 물고기 이동 후 상어가 갈 수 있는 칸 체크
		arr = checkMove(map, sx, sy, sdir, tempFish);
		
		//상어가 갈 수 있는 칸이 없으면 잡아먹은 물고기 번호 합 answer에 저장
		if (arr.size() == 0) {
			answer.add(result);
			return;
		}
		
		//갈 수 있는 칸들에 대해서 재귀를 돌려서 각각 상어가 가는 경우의 수를 모두 체크
		//여기서 상어가 이동하는 로직
		
		for (int i = 0; i < arr.size(); i++) {
			Fish f = arr.get(i);
			int[][] temp = new int[4][4];
			for (int j = 0; j < 4; j++) {
				temp[j] = Arrays.copyOf(map[j], 4);
			}
			//트리맵또한 각 경우마다 지워지는게 다르기 때문에 새로 복사해서 사용
			//result도 복사해서 사용해줘야함 안그러면 계속 값이 더해짐.
			TreeMap<Integer, Fish> tempF = (TreeMap<Integer, Fish>) tempFish.clone();
			int tempResult = result;
			tempResult += temp[f.x][f.y];
			tempF.remove(temp[f.x][f.y]);
			temp[f.x][f.y] = 0;
			//복사한 값들로 다음 경우 수행
			sharkMove(temp, f.x, f.y, f.dir, tempResult, tempF);
		}
	}

	public static void moveFish(int[][] map, TreeMap<Integer, Fish> fish, int sx, int sy) {
		// 물고기 순서대로
		for (Integer key : fish.keySet()) {
			Fish now = fish.get(key);
			int dir = now.dir;
			int count = 0;
			// 45도 회전하면서 갈 수 있는 곳 찾기
			while (count < 8) {
				int nx = now.x + dx[dir];
				int ny = now.y + dy[dir];
				if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4 || (nx == sx && ny == sy)) {
					dir = (dir % 8) + 1;
					count++;
				} else {
					// 갈 수 있는 곳을 찾으면
					// 위치 변경 + map정보 변경
					if(map[nx][ny] > 0) {
						//두 물고기 위치 변경 후
						//map에 저장된 각 물고기의 정보도 바꿔줌
						int swapDir = fish.get(map[nx][ny]).dir;
						int temp = map[now.x][now.y];
						map[now.x][now.y] = map[nx][ny];
						map[nx][ny] = temp;
						fish.put(map[now.x][now.y], new Fish(now.x, now.y, swapDir));
						fish.put(map[nx][ny], new Fish(nx, ny, dir));
					}else {
						//만약 빈칸이면 그냥 옮기고 기존 위치 제거
						map[nx][ny] = map[now.x][now.y];
						map[now.x][now.y] = 0;
						fish.put(key, new Fish(nx, ny, dir));
					}
					break;
				}
			}
		}
	}

}
