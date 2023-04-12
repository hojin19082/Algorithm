package ÀÌºÐÅ½»ö;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class ¸ÔÀ»°Í¸ÔÈú°Í {

	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		

		for(int tc = 0; tc < T ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] eating = new int[N];
			int[] eated = new int[M];
			st=  new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				eating[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				eated[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(eating);
			Arrays.sort(eated);
			int count = 0;
			for(int i=N-1; i>=0; i--) {
				int k = eating[i];
				
				if(k > eated[M-1]) {
					count += M;
				}else {
					for(int j=M-1; j>=0; j--) {
						if(eated[j] < k) {
							count += j+1;
							break;
						}
					}
				}	
			}
			System.out.println(count);
		}

	}

}
