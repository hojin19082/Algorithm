package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 거스름돈 {

	public static void main(String[] args)throws IOException {
 
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int count = 0;
    	while(N>0) {
    		if(N/5 >=2) {
    			N-=5;
    			count++;
    		}else {
    			if(N<5 ) {
    				if(N%2 !=0) {
    					count = -1;
        				break;
    				}else {
    					count = N/2;
    					break;
    				}
    			}
  
    			if((N%5)%2 !=0) {
    				count+= N/2;
    			}else {
    				count+= 1 + (N-5)/2;
    			}
    			N = 0;
    		}
    	}
    	System.out.println(count);
	}

}
