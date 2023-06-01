package Level2;

public class �湮���� {
	//�� ĭ���� �� �� �ִ� 4������ boolean�� �̿�.
	//���� ĭ���� �̵��� �� �ݴ��� ĭ�� ���ؼ��� �湮 ó�� �������.
	    public int solution(String dirs) {
	        int answer = 0;
	        boolean[][][] map = new boolean[11][11][4];
	        int startX = 5;
	        int startY = 5;
	        int[] dx = {-1,0,0,1};
	        int[] dy = {0,-1,1,0};
	        for(int i=0; i<dirs.length(); i++){
	            char ch = dirs.charAt(i);
	            int dir = 0;
	            if(ch == 'U'){
	                dir=0;
	            }else if(ch == 'D'){
	                dir=3;
	            }else if(ch=='R'){
	                dir=1;
	            }else{
	                dir=2;
	            }
	            int nx = startX + dx[dir];
	            int ny = startY + dy[dir];
	            
	            if(nx<0 || ny<0 ||nx>=11 || ny>=11) continue;
	            
	            if(!map[nx][ny][3-dir] && !map[startX][startY][dir]){
	                answer++;
	                map[nx][ny][3-dir]=true;
	                map[startX][startY][dir]=true;
	            }
	            
	            startX = nx;
	            startY = ny;
	        }
	        return answer;
	    }
	}

