package Level1;

public class 신규아이디추천 {

	class Solution {
	    public String solution(String new_id) {
	        //1
	        new_id = new_id.toLowerCase();
	        //2
	        for(int i=0; i<new_id.length(); i++){
	            char ch = new_id.charAt(i);
	            if(ch >= 'a' && ch<= 'z' || ch -'0' >=0 && ch-'0'<=9 || ch == '-' || ch == '_' || ch =='.'){
	                continue;
	            }else{
	                new_id = new_id.replace(ch+"", " ");
	            }
	        }
	        new_id = new_id.replace(" ", "");
	        //3
	        while(new_id.contains("..")){
	            new_id = new_id.replace("..", ".");
	        }
	        //4
	        if(new_id.length() >=1){
	            if(new_id.charAt(0) == '.'){
	                if(new_id.length() == 1){
	                    new_id = "";
	                }else{
	                    new_id = new_id.substring(1);
	                }
	            }
	        }
	        if(new_id.length() >=1){
	            if(new_id.charAt(new_id.length()-1) == '.'){
	                if(new_id.length() >=2){
	                    new_id = new_id.substring(0, new_id.length()-1);
	                }else{
	                    new_id = " ";
	                }     
	            }
	        }
	        
	        
	        //5
	        if(new_id.length() == 0){
	            new_id += "a";
	        }
	        
	        //6
	        if(new_id.length() >=16){
	            new_id = new_id.substring(0, 15);
	        }
	        
	        if(new_id.charAt(new_id.length()-1) == '.'){
	            new_id = new_id.substring(0, new_id.length()-1);
	        }
	        
	        if(new_id.length() <=2){
	            char ch = new_id.charAt(new_id.length()-1);
	            while(new_id.length()<3){
	                new_id+=ch;
	            }
	        }
	        return new_id;
	    }
	}

}
