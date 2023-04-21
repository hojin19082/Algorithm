package �ڷᱸ��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ���ǽǹ��� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		Course[] course = new Course[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			course[i] = new Course(start, end);
		}
		//���� �ð��� �������� ���� ���ְ�
		//������ ���� �ð��� �������� ��������
		Arrays.sort(course, (n1, n2) -> 
		n1.start == n2.start ? n1.end - n2.end : n1.start - n2.start);
		pq.add(course[0].end);
		for(int i=1; i<N; i++) {
			
			if(pq.peek() <= course[i].start) {
				pq.poll();
			}
			pq.add(course[i].end);
		}
		System.out.println(pq.size());
	}

}
class Course{
	int start, end;
	Course(int start, int end){
		this.start = start;
		this.end = end;
	}
}
