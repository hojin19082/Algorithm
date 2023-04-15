package Level1;

public class ���游������ {


class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        for(int i=0; i<targets.length; i++){
            String[] charArr = targets[i].split("");
            int count = 0;
            for(int j=0; j<charArr.length; j++){
                //target�� �ִ� ���ڰ� keymap�� �ִ��� Ȯ��
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
