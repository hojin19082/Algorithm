package ±×¸®µð;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class ±âÅ¸ÁÙ {
    public static void main(String[] args) throws IOException {
 
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Min = Integer.MAX_VALUE;
 
        int[] unit = new int[M];
        int[] pack = new int[M];
        for(int i=0; i<M; i++){
        	st = new StringTokenizer(br.readLine());
            pack[i] = Integer.parseInt(st.nextToken());
            unit[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(unit);
        Arrays.sort(pack);
        
        //°¡Àå ½Ñ 6°³Â¥¸® ÆÑ ±¸¸Å vs °¡Àå ½Ñ ³¹°³ ±¸¸Å vs (°¡Àå½Ñ 6°³Â¥¸® ÆÑ + ³¹°³)
        Min = Math.min(((N/6)+1)*pack[0], N*unit[0]);    
        Min = Math.min(Min, ((N/6))*pack[0] + (N%6)*unit[0]);
        
        System.out.println(Min);
    }
}
