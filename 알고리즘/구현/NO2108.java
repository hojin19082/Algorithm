package ±¸Çö;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NO2108 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] count = new int[8001];
		int[] arr2 = new int[T];
		int sum = 0;
		int max =0;
		int min =0;
		for(int tc=0; tc<T; tc++) {
			int num = Integer.parseInt(br.readLine());
			arr2[tc] = num;
			if(max < num) {
				max = num;
			}
			
			if(min > num) {
				min = num;
			}
			count[num+4000]++;
			
			sum+=num;
		}
		Arrays.sort(arr2);
		
		int fre = 0;
		int mode =0;
		boolean flag = false;
		for(int i=0; i<8001; i++) {
			if(fre < count[i]) {
				fre = count[i];
				mode = i-4000;
				flag = true;
			}else if(fre == count[i] && flag == true) {
				mode = i-4000;
				flag=false;
			}
		}

		System.out.println(Math.round((double)sum/T));
		System.out.println(arr2[T/2]);
		System.out.println(mode);
		System.out.println(arr2[T-1]-arr2[0]);
		

	}

}
