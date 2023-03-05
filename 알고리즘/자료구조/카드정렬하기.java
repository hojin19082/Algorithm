package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
public class 카드정렬하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> arr = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		
		long count = 0;
		while(arr.size() > 1) {
			int a =arr.poll();
			int b =arr.poll();
			
			count+=(long)a+b;
			arr.add(a+b);
		}
		
		System.out.println(count);
	}

}
