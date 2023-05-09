import java.util.*;
class Solution {
    // 광물 리스트에 다이아부터 나온다는 보장이 없으므로
    // 재귀를 통해 모든 경우의 수를 구한 후 가장 작은 값 찾기
    static int answer = Integer.MAX_VALUE;
    static int total;
    static ArrayList<Integer>result = new ArrayList<>();
    static int[][] pirodo = {{1,1,1}, {5,1,1}, {25, 5, 1}};
    static Map<String, Integer> map = new HashMap<>();
    public int solution(int[] picks, String[] minerals) { 
        total = picks[0] + picks[1] + picks[2];
        //이중 배열로 된 피로도를 구하기 위해 미리 map에 광물에 대한 번호를 저장
        map.put("diamond", 0);
        map.put("iron", 1);
        map.put("stone" ,2);
        dfs(picks, minerals);
        return answer;
    }
    public static void dfs(int[] picks, String[] minerals){
      //모든 곡괭이를 사용했으면
        if(result.size() == total){
            int count = 0;
            for(int i=0; i<minerals.length; i++){
                if((i/5)==result.size())break;
                count += pirodo[result.get(i/5)][map.get(minerals[i])];
            }
            answer = Math.min(answer, count);
        }
        for(int i=0; i<3; i++){
            if(picks[i] !=0){
                result.add(i);
                picks[i] -=1;
                dfs(picks, minerals);
                result.remove(result.size()-1);
                picks[i]+=1;
            }
        }
    }
}
