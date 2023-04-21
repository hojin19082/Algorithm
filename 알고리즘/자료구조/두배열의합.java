package �ڷᱸ��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class �ι迭���� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N];
		StringTokenizer st =new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		int[] b = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Long> arr1 = new ArrayList<>();
		ArrayList<Long> arr2 = new ArrayList<>();
		
		accumulateSum(arr1, a);
		accumulateSum(arr2, b);
		
		Collections.sort(arr1);
		Collections.sort(arr2);
		
		long count = 0;
		for(long num : arr1) {
			count+= calValue(T-num, arr2);
		}
		System.out.println(count);
	}
	//�� �迭���� ���ӵǰ� ���� �� �ִ� ������ �� ����
	public static void accumulateSum(ArrayList<Long> arr, int[] array) {
		for(int i=0; i<array.length; i++) {
			long sum = 0;
			for(int j=i; j<array.length; j++) {
				sum+=array[j];
				arr.add(sum);
			}
		}
	}
	public static int calValue(long l, ArrayList<Long>arr2) {
		// �������� ��� B�迭���� �̺�Ž���� target���� T- A�� ���������� ���� ��
		// B����Ʈ���� �̺�Ž���� ���ؼ� T-A ���� ������ ã�´�\
		
		
		int left = 0;
		int right = 0;
				
		int start = 0;
		int end = arr2.size()-1;
		// start�� end������ ������ �ݺ��ϸ�
		// end���� target���� ���� index�� �����
		while(start<=end) {
			int mid = (start+end)/2;
			if(arr2.get(mid) >= l) {
				end = mid-1;
			}else {
				start = mid+1;
			}
			System.out.println(start+ " " + end);
		}
		
		left = end;
		start = 0;
		end = arr2.size()-1;
		// start�� end������ ������ �ݺ��ϸ�
		// end���� target�� ������ ���� ������ index�� ����
		while(start<=end) {
			int mid = (start+end)/2;
			if(arr2.get(mid) <= l) {
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		right = end;
		return right - left;
	}

}
