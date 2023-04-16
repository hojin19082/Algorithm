package �̺�Ž��;

import java.io.*;
import java.util.*;
public class ��ο�ٸ� {
    static int[] Arr;
    static int N,M;
    public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N =Integer.parseInt(br.readLine()); //���ٸ��� ����
        M =Integer.parseInt(br.readLine()); //��ġ�� ���μ� ����.
        Arr = new int[M];// ���ε��� ��ġ�� ���� �Է� �ޱ�
        
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