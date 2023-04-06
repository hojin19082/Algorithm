package ÀÚ·á±¸Á¶;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Àý´ñ°ªÈü {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq1 = new PriorityQueue<>();
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num != 0) {
				if(num > 0) {
					pq1.offer(num);
				}else {
					pq2.offer(num);
				}
			}else {
				if(pq1.isEmpty() && pq2.isEmpty()) {
					System.out.println("0");
				}else if(pq1.isEmpty() && !pq2.isEmpty()) {
					System.out.println(pq2.poll());
				}else if(!pq1.isEmpty() && pq2.isEmpty()) {
					System.out.println(pq1.poll());
				}else {
					if(Math.abs(pq1.peek()) == Math.abs(pq2.peek())) {
						System.out.println(pq2.poll());
					}else if(Math.abs(pq1.peek()) > Math.abs(pq2.peek())) {
						System.out.println(pq2.poll());
					}else {
						System.out.println(pq1.poll());
					}
					
				}
			}
		}
		
	}

}

