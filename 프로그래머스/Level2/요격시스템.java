package Level2;
import java.util.*;
public class 요격시스템 {
	//끝나는 지점을 오름차순으로 정렬해야 함!
    public int solution(int[][] targets) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(targets, (o1, o2) -> {
            if(o1[1] == o2[1]){
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        
        for(int i=0; i<targets.length; i++){
            if(list.size() == 0){
                list.add(targets[i][1]);
            }else{
                if(list.get(0) > targets[i][0]){
                    list.add(targets[i][0]);
                }else{
                    answer++;
                    list.clear();
                    list.add(targets[i][1]);
                }
            }
        }
        list.clear();
        answer++;
        return answer;
    }
}
