package ���ڵ�;

import java.util.*;
import java.io.*;
public class �����ߺ����������ߺ����� {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//n�� �� r���� �̴� ��
		int n = Integer.parseInt(br.readLine());
		int r = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		
		List<Integer> list = new ArrayList<>();
		
		int[] check = new int[n];
		//����
		System.out.println("����");
		permutation(list, check, n, r);
		list.clear();
		
		//�ߺ�����
		System.out.println("�ߺ�����");
		rePermutation(list, n, r);
		list.clear();
		
		//����
		System.out.println("����");
		combination(list, n, r, 0);
		list.clear();
		
		//�ߺ�����
		System.out.println("�ߺ�����");
		reCombination(list, n, r, 0);
	}
	public static void reCombination(List<Integer> list, int n, int r, int start) {
		if(list.size() == r) {
			for(int v : list) {
				System.out.print(v + " ");
			}
			System.out.println();
			return;
		}
		for(int i=start; i<n; i++) {
			list.add(i);
			reCombination(list, n, r, i);
			list.remove(list.size()-1);
		}
	}
	public static void combination(List<Integer> list, int n, int r, int start) {
		if(list.size() == r) {
			for(int v : list) {
				System.out.print(v + " ");
			}
			System.out.println();
			return;
		}
		for(int i=start; i<n; i++) {
			list.add(i);
			combination(list, n, r, i+1);
			list.remove(list.size()-1);
		}
	}
	public static void rePermutation(List<Integer> list, int n, int r) {
		if(list.size() == r) {
			for(int v : list) {
				System.out.print(v + " ");
			}
			System.out.println();
			return;
		}
		//�ߺ������� �Ȱ��� ���ڸ� �� �־ �Ǳ� ������ �湮ó���� �ʿ� ����.
		for(int i=0; i<n; i++) {
			list.add(i);
			rePermutation(list, n, r);
			list.remove(list.size()-1);
		}
	}
	public static void permutation(List<Integer> list, int[] check, int n, int r) {
		
		if(list.size() == r) {
			for(int v : list) {
				System.out.print(v + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<n; i++) {
			//�ߺ������� �ƴϱ� ������ �ڱ��ڽ��� �� ������ �ȵ˴ϴ�. ���� �湮 ó���� ���ݴϴ�.
			if(check[i] == 0) {
				check[i] = 1;
				list.add(i);
				permutation(list, check, n, r);
				list.remove(list.size()-1);
				check[i] = 0;
			}
		}
	}

}
