package Level2;
import java.util.*;
public class 숫자변환하기 {

	public int solution(int x, int y, int n) {
        int answer = 0;
        int[] arr = new int[y+1];
         if (x == y) {
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        
        while(!queue.isEmpty()){
            int poll = queue.poll();
            int[] temp = new int[3];
            temp[0] = poll + n;
            temp[1] = poll * 2;
            temp[2] = poll * 3;

            for(int i=0; i<3; i++){
                int next = temp[i];
                if(next > y){
                    continue;
                }
                
                if(arr[next] == 0 || arr[next] > arr[poll] + 1){
                    arr[next] = arr[poll] + 1;
                    queue.add(next);
                }
            }
        }
        return arr[y] !=0 ? arr[y] : -1;
    }

}
