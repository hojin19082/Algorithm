package Level1;
import java.awt.*;
public class 키패드누르기 {

	    public String solution(int[] numbers, String hand) {
	        String answer = "";
	        Point left = new Point(4,1);
	        Point right = new Point(4,3);
	        for(int i=0; i<numbers.length; i++){
	            int num = numbers[i];
	            Point p;
	            if(num == 0){
	                p = new Point(4,2);
	                num = 2;
	            }else{
	                if(num % 3 ==0){
	                    p = new Point(num/3, 3);
	                }else{
	                    p = new Point(num/3 + 1, num % 3);
	                }
	            }
	            //왼손
	            if(num % 3 == 1){
	                left.x = p.x;
	                left.y = p.y;
	                answer+="L";
	            }else if(num % 3 == 0){
	                right.x = p.x;
	                right.y = p.y;
	                answer+= "R";
	            }else{
	                if(Math.abs(p.x - left.x) + Math.abs(p.y - left.y) <
	               Math.abs(p.x - right.x) + Math.abs(p.y - right.y)){
	                left.x = p.x;
	                left.y = p.y;
	                answer += "L";
	                //오른손
	            }else if(Math.abs(p.x - left.x) + Math.abs(p.y-left.y) >
	               Math.abs(p.x - right.x) + Math.abs(p.y - right.y)){
	                right.x = p.x;
	                right.y = p.y;
	                answer += "R";
	            }else{
	                //같을 경우
	                if(hand.equals("right")){
	                    //오른손
	                    right.x = p.x;
	                    right.y = p.y;
	                    answer += "R";
	                }else{
	                    left.x = p.x;
	                    left.y = p.y;
	                    answer += "L";
	                }
	            }
	            }
	        }
	        return answer;
	    }
	
}
