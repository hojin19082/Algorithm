package Level1;

public class 대충만든자판 {


class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        for(int i=0; i<targets.length; i++){
            String[] charArr = targets[i].split("");
            int count = 0;
            for(int j=0; j<charArr.length; j++){
                //target에 있는 문자가 keymap에 있는지 확인
                int min = Integer.MAX_VALUE;
                
                for(int t=0; t<keymap.length; t++){
                    
                    if(keymap[t].contains(charArr[j])){
                        min = Math.min(min, keymap[t].indexOf(charArr[j]));
                    }
                }
                
                if(min == Integer.MAX_VALUE) {
                    count = 0;
                    break;
                }
                count += min +1;
            }
            if(count == 0) answer[i] = -1;
            else answer[i] = count;
        }
        return answer;
    }
}

}
