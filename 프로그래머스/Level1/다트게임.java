package Level1;

public class 다트게임 {

	class Solution {
	    public int solution(String dartResult) {
	        int answer = 0;
	        int[] score = new int[3];
	        String num = "";
	        int j = 0;
	        for(int i=0; i<dartResult.length(); i++){
	            if(dartResult.charAt(i) -'0'>=0 && dartResult.charAt(i) -'0' <=9){
	                num += dartResult.charAt(i)+"";
	            }else{
	                if(dartResult.charAt(i) == 'S'){
	                    score[j] = Integer.parseInt(num);
	                    j++;
	                }else if(dartResult.charAt(i) == 'D'){
	                    score[j] = (int)Math.pow(Integer.parseInt(num),2);
	                    j++;
	                }else if(dartResult.charAt(i) == 'T'){
	                    score[j] = (int)Math.pow(Integer.parseInt(num),3);
	                    j++;
	                }else if(dartResult.charAt(i) == '*'){
	                    if(j==1){
	                        score[j-1] = score[j-1] * 2;
	                    }else{
	                        score[j-1] = score[j-1] * 2;
	                        score[j-2] = score[j-2] * 2;
	                    }
	                }else if(dartResult.charAt(i) == '#'){
	                    score[j-1] = score[j-1] * -1;
	                }
	                num = "";
	            }
	            
	        }
	        
	        for(int i=0; i<3; i++){
	            answer += score[i];
	        }
	        return answer;
	    }
	}

}
