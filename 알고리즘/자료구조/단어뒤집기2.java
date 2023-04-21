package 자료구조;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class 단어뒤집기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String answer = "";
		int length = str.length()-1;
		//먼저 <>가 있는지 확인
		if(str.contains("<")) {
			while(str.length() > 0 && str.contains("<")){
				if(str.charAt(0) == '<') {
					answer += str.substring(0, str.indexOf('>')+1);
				}else {
					int index = str.indexOf('<');
					String temp = str.substring(0, index);
					
					answer += check(temp);
					answer += str.substring(index, str.indexOf('>')+1);
				}
				if(str.indexOf('>') != length) str = str.substring(str.indexOf('>')+1);
				else str = "";
			}
			answer += check(str);
		}else {
			answer += check(str);
		}
		System.out.println(answer);
	}
	public static String check(String temp) {
		//공백이 포함되어 있으면
		String result = "";
		if(temp.contains(" ")) {
			String[] arr = temp.split(" ");
			for(int j=0; j<arr.length; j++) {
				StringBuilder sb = new StringBuilder();
				if(j == arr.length-1) result += sb.append(arr[j]).reverse().toString();
				else result += sb.append(arr[j]).reverse().toString() + " ";
			}
		}else {
			StringBuilder sb = new StringBuilder();
			result += sb.append(temp).reverse().toString();
		}
		return result;
	}
}
