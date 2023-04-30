package Level2;
import java.util.*;
public class 가장큰수 {
	//순열을 통해 모든 경우의 수를 구한 후 가장 큰 값을 뽑으려 했지만 시간초과 발생
	//따라서 string 배열로 전환 후 정렬할 때, 각 원소를 더했을 때 가장 큰 값이 나올 수 있도록 정렬
		class Solution {
	    public String solution(int[] numbers) {

	        String[] str = new String[numbers.length];
	        
	        //int배열 String배열로 변환
	        for(int i = 0; i < numbers.length; i++){
	            str[i] = String.valueOf(numbers[i]);
	        }     
	        //각 원소를 이어 붙였을 때 가장 큰 값이 되도록 정렬
	        //내림차순 : (o2+o1).compareTo(o1+o2);
	        //오름차순 : (o1+o2).compareTo(o1+o2);
	        Arrays.sort(str, (o1, o2)-> (o2+o1).compareTo(o1+o2));
	        
	        //원소의 값이 0일 수도 있음.
	        if (str[0].equals("0")) return "0";
	        
	        String answer = "";
	        for(int i=0; i<str.length; i++){
	            answer += str[i];
	        }
	        return answer;
	    }
	}

}
