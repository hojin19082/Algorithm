package �׸���;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class ������ {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		//sum�� ���� int������ ���� �� �����Ƿ� longŸ��
		//sum�� ���ϱ� ���� �ʿ��� ���鵵 ��� longŸ������ ����
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
