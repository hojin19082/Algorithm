package ±¸Çö;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ÀÒ¾î¹ö¸°°ýÈ£ {

	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("-");
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<str.length; i++) {
			int temp = 0;
			String[] add =str[i].split("\\+");
			
			for(int j=0; j<add.length; j++) {
				temp += Integer.parseInt(add[j]);
			}
			
			if(min == Integer.MAX_VALUE) {
				min = temp;
			}else {
				min -= temp;
			}
		}
		
		System.out.println(min);
	}

}
