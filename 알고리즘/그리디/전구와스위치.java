package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 전구와스위치 {
	static int N;
	static int count1 = 0, count2 = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		char[] before = br.readLine().toCharArray();
		char[] after = br.readLine().toCharArray();

		char[] openBefore = new char[N];
		for (int i = 0; i < before.length; i++) {
			openBefore[i] = before[i];
		}
		
		int count1 = 0;
		int count2 = 0;
		
		if(after[0] == '1'){
            lightSwitch(openBefore, 0);
            count2 +=1;
        }else{
            lightSwitch(before, 0);
            count1 +=1;
        }
		
		 for(int i=1; i<N; i++){
	            if(after[i-1] != before[i-1]){
	                lightSwitch(before, i); count1+=1;
	            }
	            
	            
	            if(after[i-1] != openBefore[i-1]){
	                lightSwitch(openBefore , i); count2 += 1;
	            }
	        }
		
		
		for (int i = 0; i < before.length; i++) {
			if (before[i] != after[i]) {
				count1 = Integer.MAX_VALUE;
				break;
			}
		}

		for (int i = 0; i < openBefore.length; i++) {
			if (openBefore[i] != after[i]) {
				count2 = Integer.MAX_VALUE;
				break;
			}
		}

		if (count1 == Integer.MAX_VALUE && count2 == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(Math.min(count1, count2));
		}
	}
	 private static void lightSwitch(char[] light, int n) {
	        if(n != 0) light[n-1] = swap(light[n-1]);
	        light[n] = swap(light[n]);
	        if(n != N-1) light[n+1] = swap(light[n+1]);
	    }
	 
	 private static char swap(char n){
	        return n == '0' ? '1' : '0';
	    }

}
