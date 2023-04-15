package Level1;

public class 공원산책 {

	class Solution {
	    public int[] solution(String[] park, String[] routes) {
	        int[] answer = new int[2];
	        char[][] map = new char[park.length][park[0].length()];
	        //이동하기전 공원 벗어나는 지 확인
	        //이동 중 장애물 있는지 확인
	        //둘 중 하나라도 있으면 무시
	        int x = -1;
	        int y = -1;
	        int N = park.length-1;
	        int M = park[0].length()-1;
	        for(int i=0; i<park.length; i++){
	            for(int j=0; j<park[i].length(); j++){
	                map[i][j] = park[i].charAt(j);
	                if (map[i][j] == 'S'){
	                    x = i;
	                    y = j;
	                }
	            }
	        }
	        
	        for(int i=0; i<routes.length; i++){
	            char dir = routes[i].charAt(0);
	            int count = routes[i].charAt(2)-'0';
	            
	            if(dir == 'E'){
	                if(y + count > M) continue;
	                boolean flag = false;
	                for(int move = 1; move<=count; move++){
	                    if(map[x][y+move] == 'X') {
	                        flag = true;
	                        break;
	                    }
	                }
	                if(!flag) y += count;
	            }else if(dir == 'N'){
	                if(x - count < 0) continue;
	                boolean flag = false;
	                for(int move = 1; move<=count; move++){
	                    if(map[x-move][y] == 'X') {
	                        flag = true;
	                        break;
	                    }
	                }
	                if(!flag) x -= count;
	            }else if(dir == 'S'){
	                if(x + count > N) continue;
	                boolean flag = false;
	                for(int move = 1; move<=count; move++){
	                    if(map[x+move][y] == 'X') {
	                        flag = true;
	                        break;
	                    }
	                }
	                if(!flag) x += count;
	            }else {
	                if(y - count < 0) continue;
	                boolean flag = false;
	                for(int move = 1; move<=count; move++){
	                    if(map[x][y-move] == 'X') {
	                        flag = true;
	                        break;
	                    }
	                }
	                if(!flag) y -= count;
	            }
	        }
	        answer[0]=x;
	        answer[1]=y;
	        return answer;
	    }
	}

}
