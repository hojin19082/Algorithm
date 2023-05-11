import java.util.*;
class Solution {
    //귤의 크기마다 개수를 구한 후 내림차순 정렬
    //K에서 귤의 개수를 빼가면서 K가 1보다 작을때가 서로 다른 종류 수 최소!
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map <Integer, Integer> map = new HashMap<>();
        for(int i=0; i<tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0)+1);
        }
        
        ArrayList<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values, Collections.reverseOrder());
        for(Integer a:values){
            k-=a;
            answer++;
            if(k<1){
                return answer;
            }
        }
        return answer;
    }
   
}
