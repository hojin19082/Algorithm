package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 신입사원 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			int N = Integer.parseInt(br.readLine());
			Score[] score = new Score[N];
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				score[i] = new Score(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				
			}
			Arrays.sort(score, (o1, o2) -> {
				return o1.x - o2.x;
			});
			
			int answer = 1;
			int cscore = score[0].y;
			int pre_s = score[0].x;
			int pre_c = score[0].y;
			for(int i=1; i<N; i++) {
				if(score[i].y < cscore) {
					if(pre_s > score[i].x || pre_c > score[i].y) {
						pre_s = score[i].x;
						pre_c = score[i].y;
						answer++;
					}
				}
				
			}
			System.out.println(answer);
		}

	}

}
class Score {
	int x;
	int y;
	Score(int x, int y){
		this.x = x;
		this.y = y;
	}
}
