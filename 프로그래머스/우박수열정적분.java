import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        ArrayList<Integer> arr = new ArrayList<>();
        while(true){
            arr.add(k);
            if(k==1) break;
            if(k % 2 == 0){
                k /= 2;
            }else{
                k = k*3+1;
            }
        }
        //각 구간마다 넓이 구하기
        int prev = arr.get(0);
        double[] sjql = new double[arr.size()-1];
        for(int i = 1; i<arr.size(); i++){
            if(arr.get(i) >= prev){
                sjql[i-1] = (double) prev + ((double)(arr.get(i)-prev)/2);
            }else{
                sjql[i-1] = (double) arr.get(i) + ((double)(prev - arr.get(i))/2);
            }
            prev = arr.get(i);
        }
        
        for(int i=0; i<ranges.length; i++){
            int a = ranges[i][0];
            int b = arr.size()-1 + ranges[i][1];
            if(a > b) answer[i] = -1.0;
            else{
                for(int j=a; j<b; j++){
                    answer[i] += sjql[j];
                }
            }
        }
        return answer;
    }
}
