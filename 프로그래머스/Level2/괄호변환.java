package Level2;
import java.util.*;
public class 괄호변환 {

	class Solution {
	    public String solution(String p) {
	        String answer = cal(p);
	        return answer;
	    }
	    public  String cal(String p){
	        if(p.length() == 0){
	            return "";
	        }
	        int open = 0;
	        int close = 0;
	        String u = "";
	        String v = "";
	        for(int i=0; i<p.length(); i++){
	            if(p.charAt(i) == '(') open++;
	            else close++;
	            if(open == close){
	                if(i==p.length()-1){
	                    u = p.substring(0);
	                    v = "";
	                }else{
	                    u = p.substring(0, i+1);
	                    v = p.substring(i+1);
	                }
	                break;
	            }
	        }
	        
	        //u가 올바른지 확인
	        boolean right = true;
	        int a =0, b=0;
	        for(int i=0; i<u.length(); i++){
	            if(u.charAt(i) == '(') a++;
	            else b++;
	            if(b > a) {
	                right = false;
	                break;
	            }
	        }
	        //v가 올바른지 확인
	        boolean right_v = true;
	        int c =0, d=0;
	        for(int i=0; i<v.length(); i++){
	            if(v.charAt(i) == '(') c++;
	            else d++;
	            if(d > c) {
	                right_v = false;
	                break;
	            }
	        }
	        
	        String result = "";
	        if(right && right_v) result = p;
	        else{
	            if(!right){
	            result = rightCal(v);
	            u = u.substring(1, u.length()-1);
	            String temp = "";
	            for(int i=0; i<u.length(); i++){
	                if(u.charAt(i) == '(') temp+=")";
	                else temp+="(";
	            }
	            result+=temp;
	        }else{
	            result+=u;
	            result += cal(v);
	        }
	        }
	        return result;
	    }
	    public  String rightCal(String v){
	        String result = "(";
	        String temp = cal(v);
	        result += temp + ")";
	        return result;
	    }
	}

}
