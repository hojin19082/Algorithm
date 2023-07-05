package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쿠키의신체측정 {

	public static void main(String[] args)  throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		char[][] map = new char[N+1][N+1];
		for(int i=1; i<=N; i++) {
			String str = br.readLine();
			for(int j=1; j<=N; j++) {
				map[i][j] = str.charAt(j-1);
			}
		}
		boolean head = false;
		int heartX = 0;
		int heartY = 0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(!head && map[i][j] == '*') {
					head = true;
					heartX = i+1;
					heartY = j;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(heartX + " " + heartY).append("\n");
		
		//왼쪽팔
		int leftY = heartY-1;
		int leftArm = 0;
		while(leftY > 0 && map[heartX][leftY]== '*') {
			leftArm++;
			leftY--;
		}
		
		//오른쪽 팔
		int rightY = heartY+1;
		int rightArm = 0;
		while(rightY < N+1 && map[heartX][rightY]== '*') {
			rightArm++;
			rightY++;
		}
		
		//허리
		int wallet = heartX+1;
		int walletCount = 0;
		while(map[wallet][heartY]=='*') {
			wallet++;
			walletCount++;
		}
		
		//왼쪽 다리
		int leftLegX = wallet;
		int leftLegY = heartY-1;
		int leftLeg = 0;
		while(leftLegX < N+1 && map[leftLegX][leftLegY] == '*') {
			leftLegX++;
			leftLeg++;
		}
		
		//오른쪽 다리
		int rightLegX = wallet;
		int rightLegY = heartY+1;
		int rightLeg = 0;
		while(rightLegX < N+1 && map[rightLegX][rightLegY] == '*') {
			rightLegX++;
			rightLeg++;
		}
		
		sb.append(leftArm + " " + rightArm + " " + walletCount + " " + leftLeg + " "+ rightLeg);
		System.out.println(sb.toString());
	}

}