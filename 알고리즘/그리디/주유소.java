package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 주유소 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		//sum의 값이 int범위를 넘을 수 있으므로 long타입
		//sum을 구하기 위해 필요한 값들도 모두 long타입으로 선언
		long[] city = new long[N];
		long[] road = new long[N-1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N-1; i++) {
			road[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			city[i] = Integer.parseInt(st.nextToken());
		}
		long sum = 0;
		long minCost = city[0];

		for(int i=0; i<N-1; i++) {
			if(minCost > city[i]) {
				minCost = city[i];
			}
			sum+= minCost * road[i];
		}
		
		
		System.out.println(sum);
	}
}
