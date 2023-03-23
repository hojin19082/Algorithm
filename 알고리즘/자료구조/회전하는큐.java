package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 회전하는큐 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> deque = new LinkedList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for(int i = 1; i <= N; i++) {
			deque.offer(i);
		}
		
		int[] seq = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		for (int i=0; i<M; i++) {
			int index = deque.indexOf(seq[i]);
			int half;
			if(deque.size() % 2 == 0) {
				half = deque.size() / 2 -1;
			}else {
				half = deque.size() / 2;
			}
			
			if(index <= half) {
				for(int j=0; j<index; j++) {
					int temp = deque.pollFirst();
					deque.offerLast(temp);
					count++;
				}
			}else {
				for(int j=0; j<deque.size() - index; j++) {
					int temp = deque.pollLast();
					deque.offerFirst(temp);
					count++;
				}
			}
			deque.pollFirst();
		}
		System.out.println(count);
	}

}
