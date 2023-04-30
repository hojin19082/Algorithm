package Level2;
import java.util.*;
public class ����ū�� {
	//������ ���� ��� ����� ���� ���� �� ���� ū ���� ������ ������ �ð��ʰ� �߻�
	//���� string �迭�� ��ȯ �� ������ ��, �� ���Ҹ� ������ �� ���� ū ���� ���� �� �ֵ��� ����
		class Solution {
	    public String solution(int[] numbers) {

	        String[] str = new String[numbers.length];
	        
	        //int�迭 String�迭�� ��ȯ
	        for(int i = 0; i < numbers.length; i++){
	            str[i] = String.valueOf(numbers[i]);
	        }     
	        //�� ���Ҹ� �̾� �ٿ��� �� ���� ū ���� �ǵ��� ����
	        //�������� : (o2+o1).compareTo(o1+o2);
	        //�������� : (o1+o2).compareTo(o1+o2);
	        Arrays.sort(str, (o1, o2)-> (o2+o1).compareTo(o1+o2));
	        
	        //������ ���� 0�� ���� ����.
	        if (str[0].equals("0")) return "0";
	        
	        String answer = "";
	        for(int i=0; i<str.length; i++){
	            answer += str[i];
	        }
	        return answer;
	    }
	}

}
