package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 카드2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			q.offer(i);
		}
		
		while(true) {
			if(q.size() == 1) break;
			q.poll();
			q.offer(q.poll());
		}
		
		System.out.println(q.poll());
	}

}
