package 카카오기출2021;

public class 숫자문자열과영단어 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		class Solution {
		    public int solution(String s) {
		        String answer ="";
		        int i=0;
		        while(i<s.length()){
		            char ch = s.charAt(i);
		            String temp ="";
		            if(ch =='o'){
		                temp = "1";
		                i+=3;
		            }else if(ch =='t'){
		                if(s.charAt(i+1) == 'w'){
		                    temp = "2";
		                    i+=3;
		                }else{
		                    temp = "3";
		                    i+=5;
		                }
		            }else if(ch =='f'){
		                if(s.charAt(i+1) == 'o'){
		                    temp = "4";
		                    i+=4;
		                }else{
		                    temp = "5";
		                    i+=4;
		                }
		            }else if(ch == 's'){
		                if(s.charAt(i+1) == 'i'){
		                    temp = "6";
		                    i+=3;
		                }else{
		                    temp = "7";
		                    i+=5;
		                }
		            }else if(ch == 'e'){
		                temp = "8";
		                i+=5;
		            }else if(ch == 'n'){
		                temp = "9";
		                i+=4;
		            }else if(ch =='z'){
		                temp = "0";
		                i+=4;
		            }else{
		                answer = answer + ch;
		                i++;
		            }
		            answer = answer + temp;
		        }
		        
		        return Integer.parseInt(answer);
		    }
		}
	}

}
