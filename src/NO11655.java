import java.io.*;
public class NO11655 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st = br.readLine();
		
		for(int i=0; i<st.length();i++) {
			char ch = (char) st.charAt(i);
			if((ch>= 'A' && ch<='Z' - 13) || (ch>= 'a' && ch<='z' -13)) {
				ch = (char) (ch + 13);
				
			}else if ((ch>='Z'-13 && ch<='Z') || (ch>='z' -13 && ch<='z')) {
				ch = (char) (ch - 13);
			}
			System.out.print(ch);
		}
	}

}
