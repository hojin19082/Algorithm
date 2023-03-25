package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
public class 치킨배달 {
	static int N,M;
	static int[][] map;
	static int answer = Integer.MAX_VALUE;
	static ArrayList<point> home;
    static ArrayList<point> chicken;
    static boolean[] open;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				 
				if(map[i][j] == 1) {
					home.add(new point(i,j));
				}else if(map[i][j] == 2) {
					chicken.add(new point(i,j));
				}
			}
		}
		open = new boolean[chicken.size()];
		dfs(0,0);
		System.out.println(answer);

	}
	//start는 치킨 시작할 집, count는 현재 치킨집 뽑은 개수
	public static void dfs(int start, int count) {
		//치킨집의 개수를 M개 뽑았으면 각 집과 뽑힌 치킨 집을 뽑아 거리 비교 후 가장짧은거리 저장
		//가장 짧은 거리와 answer 비교 더 짧은거로.
		if(count == M) {
			int sum = 0;
			
			for(int i=0; i<home.size(); i++) {
				int temp = Integer.MAX_VALUE;
				for(int j=0; j<chicken.size(); j++) {
					if(open[j]) {
						int distance = Math.abs(home.get(i).x - chicken.get(j).x)
								+ Math.abs(home.get(i).y - chicken.get(j).y);
						
						temp = Math.min(temp, distance);
					}
				}
				sum += temp;
			}
			answer = Math.min(answer, sum);
			return;
		}
		
		for(int i=start; i<chicken.size(); i++) {
			open[i] = true;
			dfs(i+1, count+1);
			open[i] = false;
		}
		
		
	}
}

class point{
	int x;
	int y;
	point(int x, int y){
		this.x = x;
		this.y = y;
	}
}