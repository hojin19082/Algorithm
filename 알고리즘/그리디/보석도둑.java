package �׸���;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class �������� {
	public static void main(String[] args)  throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] bag = new int[K];
		Node[] node = new Node[N];
		//���� ����
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			node[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		//���� ����
		for(int i=0; i<K; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}

		//���԰� ���� �� ���� ��������
		Arrays.sort(node, (o1, o2) -> {
			if(o1.weight == o2.weight) {
				return o2.cost - o1.cost;
			}
				
			return o1.weight - o2.weight;
		});

		Arrays.sort(bag);
		// �׻� ������ �������� ���ĵǵ��� ����(���ο� ���� ���� ������ ���� ū ������ ���� ������ ����)
		PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
 		long answer = 0;
		
		for(int i=0, j=0; i<K; i++) {
			while(j<N && node[j].weight <= bag[i]) {
				q.offer(node[j].cost);
				j++;
			}
			if(!q.isEmpty()) {
				answer += q.poll();
			}
		}
		
		System.out.println(answer);
	}
}
class Node{
	int weight;
	int cost;
	Node(int weight, int cost){
		this.weight = weight;
		this.cost = cost;
	}
}
