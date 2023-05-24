import java.util.*;
class Solution {
    static int[] discount = {40,30,20,10};
    static int answer_total = 0;
    static int answer_count = 0;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        dfs(emoticons.length, new ArrayList<>(), users, emoticons);
        answer[0] = answer_count;
        answer[1] = answer_total;
        return answer;
    }public static void dfs(int count, ArrayList<Integer> arr, int[][] users, int[] emoticons){
        if(count == arr.size()){
            //이모티콘 할인율에 따른 고객의 구매
            int total_price = 0;
            int subscribe = 0;
            //한 사람이 여러 이모티콘을 사는 경우이므로
                for(int i=0; i<users.length; i++){
                    int purchase = 0;
                    for(int k = 0; k<arr.size(); k++){
                        int dis = arr.get(k);
                        if(users[i][0] > dis) continue;
                        purchase += (emoticons[k]/100) * (100-dis);
                    }
                    //문제에서 고객이 구매한 이모티콘 가격의 합산이 자신의 돈보다 **이상**일 때 구독!
                    if(purchase >= users[i][1]){
                        subscribe++;
                    }else{
                        total_price += purchase;
                    }
                }
            
            if(answer_count == subscribe){
                answer_total = Math.max(answer_total, total_price);
            }else if(answer_count < subscribe){
                answer_count = subscribe;
                answer_total = total_price;
            }
            return;
        }
        
        for(int d=0; d<4; d++){
            arr.add(discount[d]);
            dfs(count, arr, users, emoticons);
            arr.remove(arr.size()-1);
        }
    }
}
