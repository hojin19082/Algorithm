package Level1;

public class 문자열_나누기 {

	public int solution(String s) {
        int answer = 0;
        int i=0;
        while(s.length()>0){
            char current = s.charAt(i);
            int mine = 0;
            int dif = 0;
            for(int j=0; j<s.length(); j++){
                if(current == s.charAt(j)){
                    mine++;
                }else{
                    dif++;
                }
                if(mine == dif){
                    answer++;
                    break;
                }
            }
            if(mine != dif) {
                answer++;
                break;
            }
            s = s.substring(i+mine+dif);
        }
        return answer;
    }

}
