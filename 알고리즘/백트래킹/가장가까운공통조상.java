import java.io.*;
import java.util.*;
public class 가장가까운공통조상 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		for(int T = 0; T < tc; T++) {
			int N = Integer.parseInt(br.readLine());
			int[] parent = new int[N+1];
			
			for(int i=1; i<=N; i++) {
				parent[i] = i;
			}
			for(int i=0; i<N-1; i++) {
				String[] str = br.readLine().split(" ");
				parent[Integer.parseInt(str[1])] = Integer.parseInt(str[0]);
				
			}
			String[] str = br.readLine().split(" ");
			int num1 = Integer.parseInt(str[0]);
			int num2 = Integer.parseInt(str[1]);
			ArrayList<Integer> arr1 = new ArrayList<>();
			ArrayList<Integer> arr2 = new ArrayList<>();
			find(num1, parent, arr1);
			find(num2, parent, arr2);
			System.out.println(answer(arr1, arr2));
		}
	}
	public static int answer(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
		int ans = 0;
		int first = 0;
		int second = 0;
		while(true) {
			if(arr1.isEmpty() || arr2.isEmpty()) {
				break;
			}
			first = arr1.remove(arr1.size()-1);
			second = arr2.remove(arr2.size()-1);
			if(first != second) {
				break;
			}
			ans = first;
		}
		return ans;
	}
	
	public static void find(int num, int[] parent, ArrayList<Integer> arr) {
		arr.add(num);
		if(num == parent[num]) {
			return;
		}else {
			find(parent[num], parent, arr);
		}
	}
}
