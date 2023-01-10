import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NO4948 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		while(a!=0) {
			int[] arr = new int[(123456*2)+1];
			for(int i=a+1; i<=2*a; i++) {
				arr[i] = i;
			}
			
			for(int i=2; i<=a; i++) {
				for(int j=2*i; j<=2*a; j+=i) {
					if(j<a+1 || arr[j] ==0) {
						continue;
					}else {
						arr[j] = 0;
					}
				}
			}
			int count = 0;
			for(int i=a+1; i<=2*a; i++) {
				if(arr[i]!=0) {
					count++;
				}
			}
			System.out.println(count);
			a = Integer.parseInt(br.readLine());
		}
		
	}
}
