package ±¸Çö;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class NO1966 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			ArrayList<Integer> queue = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
			
			int count = 0;
			int size = N;
			while(true) {
				int pop = queue.remove(0);
				for(int i=0; i< queue.size(); i++) {
					if(pop < queue.get(i)) {
						queue.add(pop);
						if(M == 0) {
							M = size;
						}
						break;
					}
				}
				if(size != queue.size()) {
					count++;
					if(M==0) {
						break;
					}
					size--;
				}
				M--;
			}
			System.out.println(count);
		}
		
	}

}
