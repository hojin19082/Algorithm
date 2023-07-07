package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 햄버거분배 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[N];
		char[] charArr = br.readLine().toCharArray();
		int count = 0;
		for(int i=0; i<N-1; i++) {
			if(visited[i]) continue;
			char ch = charArr[i];
			int j = i+1;
			while(j<N && j<=i+K) {
				if(visited[j]) {
					j++;
					continue;
				}
				if(ch=='H') {
					if(charArr[j] == 'P') {
						visited[j] = true;
						count++;
						break;
					}
				}else {
					if(charArr[j] == 'H') {
						visited[j] = true;
						count++;
						break;
					}
				}
				j++;
			}
		}
		System.out.println(count);
	}

}
