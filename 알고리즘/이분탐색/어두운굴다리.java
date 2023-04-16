package 이분탐색;

import java.io.*;
import java.util.*;
public class 어두운굴다리 {
    static int[] Arr;
    static int N,M;
    public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N =Integer.parseInt(br.readLine()); //굴다리의 길이
        M =Integer.parseInt(br.readLine()); //설치할 가로수 갯수.
        Arr = new int[M];// 가로등이 설치된 지점 입력 받기
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            Arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1;
        int right = N;
        int result = 0;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(possible(mid)) {
                result = mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }
        System.out.println(result);
    }

    static boolean possible(int height) {
        int prev = 0; 
        for(int i = 0; i < Arr.length; i++) {
            if(Arr[i] - height <= prev) {
                prev = Arr[i] + height;
            } else { 
            	return false; 
            }
        }
        return N - prev <= 0;
    }
}