package Level2;
import java.util.*;
public class HINDEX {
	//h�� �̻� �ο�� ���� ���� ������ ������ �� �ֱ� ������
	//h���� ������ 0~���� �������� ������ -> ����  for(int i=0; i<citations.length+1; i++)�� ����
	class Solution {
	    public int solution(int[] citations) {
	        int answer = 0;
	        int length = citations.length;
	        Arrays.sort(citations);
	        for(int i=0; i<citations.length+1; i++){
	            int h = i;
	            int count = 0;
	            for(int j=0; j<citations.length; j++){
	                if(h <= citations[j]){
	                    count++;
	                }
	            }
	            if(h<=count){
	                answer = Math.max(answer, h);
	            }
	        }
	        
	        return answer;
	    }
	}

}
