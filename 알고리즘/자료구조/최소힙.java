package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 최소힙 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num != 0) {
				pq.offer(num);
			}else {
				if(pq.isEmpty()) {
					System.out.println("0");
				}else {
					System.out.println(pq.poll());
				}
			}
		}
	}

}
