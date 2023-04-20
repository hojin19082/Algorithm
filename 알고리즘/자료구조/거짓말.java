package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 거짓말 {
	static List<Integer>[] arr;
	static boolean[] people_visited;
	static boolean[] party_visited;
	static int answer,N,M;
	static int[] people;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new ArrayList[M+1];
		people_visited=  new boolean[N+1];
		party_visited= new boolean[M+1];
		String real = br.readLine();
		if(real.length() == 1) {
			System.out.println(M);
		}else {
			String[] party= real.split(" ");
			people = new int[N+1];
			for(int i=1; i<party.length; i++) {
				people[Integer.parseInt(party[i])] = 1;
			}
			
			for(int i=1; i<=M; i++) {
				arr[i] = new ArrayList<>();
				
				String[] str = br.readLine().split(" ");
				for(int j = 1; j<str.length; j++) {
					arr[i].add(Integer.parseInt(str[j]));
				}
			}
			
			answer = M;
			find();
			System.out.println(answer);
		}
		
	}public static void find() {
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1; i<N+1; i++) {
			if(people[i] == 1) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int current  = q.poll();
			for(int i=1; i<=M; i++) {
				if(!party_visited[i] && arr[i].contains(Integer.valueOf(current))) {
					for(int v : arr[i]) {
						if(!people_visited[v]) {
							people_visited[v] = true;
							q.offer(v);
						}
					}
					answer--;
					party_visited[i] = true;
				}
			}
		}
	}

}
