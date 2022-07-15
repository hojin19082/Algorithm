import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NO1212 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String st = br.readLine();
		StringBuilder sb = new StringBuilder();
		String[] b = {"000", "001", "010", "011", "100", "101", "110", "111"};
		for(int i=0; i<st.length(); i++) {
			int c = st.charAt(i) -'0';
			if(i==0 && c<4) {
				if(c<2) {
					sb.append(b[c].substring(2));
				}else{
					sb.append(b[c].substring(1));
				}
			}else {
				sb.append(b[c]);
			}
		}
		System.out.println(sb.toString());
	}

}
