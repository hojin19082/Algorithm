import java.io.*;

public class NO1373 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String st = br.readLine();
		StringBuilder sb = new StringBuilder();

		if(st.length() % 3 == 1) {
			sb.append(st.charAt(0));
		}
		if(st.length() % 3 == 2) {
			sb.append((st.charAt(0)-'0')*2 + (st.charAt(1)-'0'));
		}
		for(int i=st.length()%3; i<st.length(); i+=3) {
			sb.append((st.charAt(i) - '0') * 4 + (st.charAt(i+1)-'0') * 2 + (st.charAt(i+2)-'0'));
		}
		System.out.println(sb);
	}

}
