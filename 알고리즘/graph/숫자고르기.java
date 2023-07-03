package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 숫자고르기 {
	//각 숫자에 대해서 cycle 가장 큰 것이 아니라
	//발생할 수 있는 cycle 개수를 모두 생각해야 함!!
	//ex 1 2 3 4
	//   2 1 4 3  이렇게 있을 때 1,2   3,4 둘의 사이클이 존재하므로 개수는 4개가 맞음
	static ArrayList<Integer> answerList;
	static boolean[] visited;
	static int num;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		visited = new boolean[N+1];
		ArrayList<Integer> same = new ArrayList<>();
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i] == i) {
				same.add(i);
			}
		}

		answerList = new ArrayList<>();
		for(int i=1; i<=N; i++) {
			visited[i] = true;
			num = i;
			dfs(i);
			visited[i] = false;
		}
		
		Collections.sort(answerList);
		StringBuilder sb = new StringBuilder();
		sb.append(answerList.size()+"\n");
		for(int i=0; i<answerList.size(); i++) {
			sb.append(answerList.get(i)+"\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void dfs(int i) {
		if(arr[i] == num) answerList.add(num);
		
		if(!visited[arr[i]]) {
			visited[arr[i]] = true;
    		dfs(arr[i]);
    		visited[arr[i]]=false;
		}

	}
}
