package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 회의실배정 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Meeting[] meetings = new Meeting[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()));
			
		}
		Arrays.sort(meetings, (m1,m2)-> m1.end == m2.end ? m1.start-m2.start : m1.end - m2.end);
		
		int count = 0;
		int prev_endTime = 0;
		for(int i=0; i<N; i++) {
			if(prev_endTime <= meetings[i].start) {
				prev_endTime = meetings[i].end;
				count++;
			}

		}
		System.out.println(count);
	}

}
class Meeting{
	int start, end;
	Meeting(int start, int end){
		this.start = start;
		this.end = end;
	}
}