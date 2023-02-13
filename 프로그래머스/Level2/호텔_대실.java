package Level2;
import java.util.*;
public class ȣ��_��� {
	//����ð��� +10�� ���ϰ� ���� ������ �ؾ��ϴµ�
	//������ �� �� +10�� ���ϰ� ����� �ϴ� �׽�Ʈ���̽� ��� ����
	 public int solution(String[][] book_time) {
	        
	        int[][] bookTime = new int[book_time.length][2];
	        for(int i=0; i<book_time.length; i++){
	            int start =Integer.parseInt(book_time[i][0].replace(":", ""));
	            int end = Integer.parseInt(book_time[i][1].replace(":", ""));
	            
	            end +=10;
	            if(end%100 >=60){
	                end+=40;
	            }
	            bookTime[i][0] = start;
	            bookTime[i][1] = end;
	        }
	        Arrays.sort(bookTime, (o1, o2) -> { 
	            
	            if(o1[0] > o2[0]) return 1;
	            else if(o1[0] < o2[0]) return -1;
	            else {
	                if(o1[1]>o2[1]) return 1;
	                else return -1;
	            }
	        });
	        
	        int min = 1;
	        for(int i=1; i<bookTime.length; i++){
	            int count = 1;
	            for(int j=0; j<i; j++){
	                if(bookTime[j][1] > bookTime[i][0]){
	                    count++;
	                    if(min<count) min = count;
	                }
	            }
	        }
	        return min;
	    }

}
