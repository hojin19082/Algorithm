package Level3;

public class 切弘取人伸取 {

	class Solution {
	    public boolean solution(int[][] key, int[][] lock) {
	        boolean answer = false;
	        int point = key.length - 1;   
	        for(int x=0; x<point + lock.length; x++){
	            for(int y=0; y<point + lock.length; y++){
	                for(int t=0; t<4; t++){
	                    int[][] map = new int[key.length * 2 + lock.length]
	                        [key.length * 2 + lock.length];
	                    for(int i = 0; i < lock.length; i++) {
	                        for(int j = 0; j < lock.length; j++) {
	                            map[i + point][j + point] = lock[i][j]; 
	                        }
	                    }
	                    match(map, key, t, x,y);
	                    if(check(map, point, lock.length)) return true;
	                }
	            }
	        }
	        return answer;
	    }
	    public void match(int[][] newLock, int[][] key, int rot, int x, int y){
	        for(int i=0; i<key.length; i++){
	            for(int j=0; j<key.length; j++){
	                if(rot == 0){
	                    newLock[x+i][y+j] += key[i][j];
	                }else if(rot == 1){
	                    newLock[x+i][y+j] += key[j][key.length-i-1];
	                }else if(rot == 2){
	                    newLock[x+i][y+j] += key[key.length-i-1][key.length- j - 1];
	                }else{
	                    newLock[x + i][y + j] += key[key.length - j - 1][i];
	                }
	            }
	        }
	    }
	    public boolean check(int[][] map, int point, int len){
	        for(int i=0; i<len; i++){
	            for(int j=0; j<len; j++){
	                if(map[point+ i][point+ j] != 1) return false;
	            }
	        }
	        return true;
	    }
	}

}
