import java.util.*;
import java.awt.Point;
class Solution {
    static int countO = 0;
    static int countX = 0;
    public int solution(String[] board) {
        List<Point> arrO = new ArrayList<>();
        List<Point> arrX = new ArrayList<>();
        for(int i=0; i<board.length; i++){
            char[] charArr = board[i].toCharArray();
            for(int j=0; j<charArr.length; j++){
                if(charArr[j] == 'O') {
                    arrO.add(new Point(i,j));
                    countO++;
                }
                else if(charArr[j] == 'X') {
                    arrX.add(new Point(i,j));
                    countX++;
                }
            }
        }
        int answer = 1;
        if(countX > countO) answer = 0;
        else if(countO - countX >=2 || countX - countO >=2) answer = 0;
        else if(countO >=3 && check(arrO) && countX == countO) answer = 0;
        else if(countX >=3 && check(arrX) && countO > countX) answer = 0;
        else if(check(arrO) && check(arrX)) answer = 0;
        return answer;
    }
    public static boolean check(List<Point> arr){
        char[][] map = new char[3][3];
        boolean flag = false;
        for(Point p : arr){
            map[p.x][p.y] = 1;
        }
        //가로
        for(int i=0; i<3; i++){
            int row = 0;
            for(int j=0; j<3; j++){
                if(map[i][j] ==1) row++;
            }
            if(row == 3 ){
                flag = true;
                break;
            }
        }
        
        //세로
        for(int i=0; i<3; i++){
            int col = 0;
            for(int j=0; j<3; j++){
                if(map[j][i] == 1) col++;
            }
            if(col == 3){
                flag = true;
                break;
            }
        }
        
        //오 대각
        int rroco = 0;
        for(int j=0; j<3; j++){
            if(map[j][j] == 1) rroco++;
        }
        if(rroco == 3) flag= true;
        //왼 대각
        int lroco = 0;
        for(int j=0; j<3; j++){
            if(map[j][2-j] == 1) lroco++;
        }
        if(lroco == 3) flag = true;
        
        return flag;
    }
}
