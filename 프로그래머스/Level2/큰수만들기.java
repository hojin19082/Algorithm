package Level2;

public class 큰수만들기 {

	//길이-k가 되기 전까지 가장 큰수 뽑아가면서 sb에 넣어주기
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int len = number.length() - k;
        int start = 0;
        while(start<number.length() && sb.length()!=len){
            int leftNum = k + sb.length() + 1;
            int max = 0;
            for(int j = start; j<leftNum; j++){
                if(max < number.charAt(j)-'0'){
                    max = number.charAt(j) - '0';
                    start = j+1;
                }
            }
            sb.append(Integer.toString(max));
        }
        return sb.toString();
    }
}

