import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class NO1427 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st = br.readLine();
		int[] num = new int[st.length()];
		for(int i=0; i<st.length(); i++) {
			num[i] = st.charAt(i) - '0';
		}

		Arrays.sort(num);
		
		for(int i=num.length-1; i>=0;
				i--) {
			System.out.print(num[i]);
		}
	}

}
