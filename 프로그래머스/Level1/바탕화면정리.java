package Level1;

public class 바탕화면정리 {

	class Solution {
	    public int[] solution(String[] wallpaper) {
	        int[] answer = new int[4];
	        int lux = Integer.MAX_VALUE;
	        int luy = Integer.MAX_VALUE;
	        int rdx = 0, rdy = 0;
	        for(int i=0; i<wallpaper.length; i++){
	            String[] str = wallpaper[i].split("");
	            for(int j=0; j<str.length; j++){
	                if(str[j].charAt(0) == '#'){
	                    lux = Math.min(lux, i);
	                    luy = Math.min(luy, j);
	                    rdx = Math.max(rdx, i+1);
	                    rdy = Math.max(rdy, j+1);
	                }
	            }
	        }
	        answer[0] = lux;
	        answer[1] = luy;
	        answer[2] = rdx;
	        answer[3] = rdy;
	        return answer;
	    }
	}

}
