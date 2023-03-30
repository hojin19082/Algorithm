package 삼성기출;

import java.util.*;
import java.io.*;

public class 톱니바퀴 {
	static int[][] arr;
	public static void main (String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[5][9];
		for(int i=1; i<=4; i++) {
			String str = br.readLine();
			for(int j=0; j<str.length(); j++) {
				arr[i][j+1] = Integer.parseInt(String.valueOf(str.charAt(j)));
			}
		}
		StringTokenizer st;
		int k = Integer.parseInt(br.readLine());
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int[] dir_arr = new int[5];
			
			//해당 톱니바퀴의 방향 저장
			dir_arr[n] = dir;
			checkDir(dir_arr, n, dir);
			
			//각 톱니의 방향이 정해지면 돌리기
			for(int j=1; j<=4; j++) {
				int[] temp = new int[9];
				temp = arr[j].clone();
				
				if(dir_arr[j] == 0) continue;
				for(int t=1; t<=8; t++) {
					if(dir_arr[j] == 1) {
						if(t == 8) {
							arr[j][1] = temp[8];
						}else {
							arr[j][t+1] = temp[t];
						}
					}else {
						if(t == 8) {
							arr[j][8] = temp[1];
						}else {
							arr[j][t] = temp[t+1];
						}
					}
				}
			}
			
		}
		int answer =0;
		for(int i=1; i<=4; i++) {
			if(arr[i][1] == 0) continue;
			else {
				if(i==1) {
					answer+=1;
				}else if(i==2){
					answer+=2;
				}else if(i==3) {
					answer+=4;
				}else {
					answer+=8;
				}
			}
		}
		System.out.println(answer);
	}
	//각 톱니의 방향을 설정
	public static void checkDir(int[] dir_arr, int n, int dir) {
		if(n==2) {
			if(arr[2][7] == arr[1][3]) {
				dir_arr[1] = 0;
			}else {
				//만약 극이 다르면 다른 방향으로
				if(dir == 1) {
					dir_arr[1] = -1;
				}else if(dir == -1){
					dir_arr[1] = 1;
				}
			}
			
			if(arr[2][3] == arr[3][7]) {
				dir_arr[3] = 0;
			}else {
				if(dir == 1) {
					dir_arr[3] = -1;
				}else if(dir == -1){
					dir_arr[3] = 1;
				}
			}
			
			if(dir_arr[3] !=0) {
				if(arr[3][3] == arr[4][7]) {
					dir_arr[4] = 0;
				}else {
					if(dir_arr[3] == 1) {
						dir_arr[4] = -1;
					}else if(dir_arr[3] == -1){
						dir_arr[4] = 1;
					}
				}
			}
				
		}else if(n==1) {
			if(arr[1][3] == arr[2][7]) {
				dir_arr[2] = 0;
			}else {
				if(dir == 1) {
					dir_arr[2] = -1;
				}else if(dir == -1){
					dir_arr[2] = 1;
				}
			}
			
			//만약 1번으로 인해 2번이 움직이면
			if(dir_arr[2] != 0) {
				if(arr[2][3] == arr[3][7]) {
					dir_arr[3] = 0;
				}else {
					if(dir_arr[2] == 1) {
						dir_arr[3] = -1;
					}else if(dir_arr[2] == -1){
						dir_arr[3] = 1;
					}
				}
			}
			
			if(dir_arr[3] !=0) {
				if(arr[3][3] == arr[4][7]) {
					dir_arr[4] = 0;
				}else {
					if(dir_arr[3] == 1) {
						dir_arr[4] = -1;
					}else if(dir_arr[3] == -1){
						dir_arr[4] = 1;
					}
				}
			}			
			
		}else if(n==4){
			if(arr[4][7] == arr[3][3]) {
				dir_arr[3] = 0;
			}else {
				if(dir == 1) {
					dir_arr[3] = -1;
				}else if(dir == -1){
					dir_arr[3] = 1;
				}
			}
			
			if(dir_arr[3] !=0) {
				if(arr[2][3] == arr[3][7]) {
					dir_arr[2] = 0;
				}else {
					if(dir_arr[3] == 1) {
						dir_arr[2] = -1;
					}else if(dir_arr[3] == -1){
						dir_arr[2] = 1;
					}
				}
			}
			
			if(dir_arr[2] !=0) {
				if(arr[1][3] == arr[2][7]) {
					dir_arr[1] = 0;
				}else {
					if(dir_arr[2] == 1) {
						dir_arr[1] = -1;
					}else if(dir_arr[2] == -1){
						dir_arr[1] = 1;
					}
				}
			}
			
		}else {
			if(arr[3][7] == arr[2][3]) {
				dir_arr[2] = 0;
			}else {
				if(dir == 1) {
					dir_arr[2] = -1;
				}else if(dir == -1){
					dir_arr[2] = 1;
				}
			}
			
			if(arr[3][3] == arr[4][7]) {
				dir_arr[4] =0;
			}else {
				if(dir == 1) {
					dir_arr[4] = -1;
				}else if(dir == -1){
					dir_arr[4] = 1;
				}
			}
			
			if(dir_arr[2] !=0) {
				if(arr[2][7] == arr[1][3]) {
					dir_arr[1] =0;
				}else {
					if(dir_arr[2] == 1) {
						dir_arr[1] = -1;
					}else if(dir_arr[2] == -1){
						dir_arr[1] = 1;
					}
				}
			}
		}
	}

}
