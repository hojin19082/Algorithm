package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 가운데를말해요 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq1 = new PriorityQueue<>();
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(pq1.size() == pq2.size()) pq2.offer(num);
			else pq1.offer(num);
			
			if(!pq1.isEmpty() && !pq2.isEmpty()) {
					if(pq1.peek() < pq2.peek()) {
						int tmp = pq1.poll();
						pq1.offer(pq2.poll());
						pq2.offer(tmp);
					}
				}
			sb.append(pq2.peek()).append("\n");
			}
		System.out.println(sb.toString());
		}
		

	}

