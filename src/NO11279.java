import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NO11279 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(N, Comparator.reverseOrder());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num!=0) {
				maxHeap.add(num);
			}else {
				if(maxHeap.isEmpty()) {
					System.out.println("0");
				}else {
				System.out.println(maxHeap.poll());
				}
			}
		}
		
	}

}
