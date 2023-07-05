package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 크로스컨트리 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc<T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			Map<Integer, Integer> map = new HashMap<>();
			
			for(int i=1; i<=N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
			}
			
			int[] team = new int[201];
			int[] teamScore = new int[201];
			ArrayList<Integer> list = new ArrayList<>();
			for(int i=1; i<=N; i++) {
				
				if(map.get(arr[i]) == 6 && team[arr[i]] == 0){
					team[arr[i]] = 6;
					list.add(arr[i]);
				}
			}
			
			Map<Integer, Integer> five = new HashMap<>();
			int score = 1;
			for(int i=1; i<=N; i++) {
				if(team[arr[i]] > 2) {
					teamScore[arr[i]] += score;
					score++;
					team[arr[i]]--;
				}else if(team[arr[i]] == 2) {
					five.put(arr[i], score);
					score++;
					team[arr[i]]--;
				}else if(team[arr[i]] == 1){
					score++;
					team[arr[i]]--;
				}
			}
			int result = 0;
			int minScore = Integer.MAX_VALUE;
			for(int i=0; i<list.size(); i++) {
				if(teamScore[list.get(i)] < minScore) {
					minScore = teamScore[list.get(i)];
					result = list.get(i);
				}else if(teamScore[list.get(i)] == minScore) {
					if(five.get(list.get(i)) < five.get(result)) {
						result = list.get(i);
					}
				}
			}
			System.out.println(result);
		}
	}

}
