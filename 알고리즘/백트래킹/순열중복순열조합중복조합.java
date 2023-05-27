package 손코딩;

import java.util.*;
import java.io.*;
public class 순열중복순열조합중복조합 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//n개 중 r개를 뽑는 것
		int n = Integer.parseInt(br.readLine());
		int r = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		
		List<Integer> list = new ArrayList<>();
		
		int[] check = new int[n];
		//순열
		System.out.println("순열");
		permutation(list, check, n, r);
		list.clear();
		
		//중복순열
		System.out.println("중복순열");
		rePermutation(list, n, r);
		list.clear();
		
		//조합
		System.out.println("조합");
		combination(list, n, r, 0);
		list.clear();
		
		//중복조합
		System.out.println("중복조합");
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
		//중복순열은 똑같은 숫자를 또 넣어도 되기 때문에 방문처리가 필요 없음.
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
			//중복순열이 아니기 때문에 자기자신을 또 뽑으면 안됩니다. 따라서 방문 처리를 해줍니다.
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
