package Level1;

public class ������å {

	class Solution {
	    public int[] solution(String[] park, String[] routes) {
	        int[] answer = new int[2];
	        char[][] map = new char[park.length][park[0].length()];
	        //�̵��ϱ��� ���� ����� �� Ȯ��
	        //�̵� �� ��ֹ� �ִ��� Ȯ��
	        //�� �� �ϳ��� ������ ����
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
