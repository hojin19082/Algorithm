import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NO10828 {
// stack
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		int top = -1;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if(str.equals("push")) {
				arr.add(Integer.parseInt(st.nextToken()));
				top++;
			}else if(str.equals("pop")) {
				if(arr.isEmpty()) {
					System.out.println("-1");
				}else {
					System.out.println(arr.get(top));
					arr.remove(top);
					top--;
				}
			}else if(str.equals("size")) {
				System.out.println(arr.size());
			}else if(str.equals("empty")) {
				if(arr.isEmpty()) {
					System.out.println("1");
				}else {
					System.out.println("0");
				}
			}else if(str.equals("top")) {
				if(arr.isEmpty()) {
					System.out.println("-1");
				}else {
					System.out.println(arr.get(top));
				}
			}
			
		}
	}

}
