import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int a = max_gcd(arrayA);
        int b = max_gcd(arrayB);
        if(a == 0 && b== 0) answer = 0;
        else{
            if(a != 0){
                int count1 = 0;
                for(int i=0; i<arrayB.length; i++){
                    if(arrayB[i] % a != 0) count1++;
                    else break;
                }
                if(count1 == arrayB.length) answer = a;
            }
            if(b!=0){
                int count2 = 0;
                for(int i=0; i<arrayA.length; i++){
                    if(arrayA[i] % b != 0) count2++;
                    else break;
                }
                if(count2 == arrayA.length) answer = Math.max(answer, b);
            }
        }
        return answer;
    }
    public static int max_gcd(int[] arr){
        Arrays.sort(arr);
        int gcd = 0;
        for(int i=2; i<=arr[0]; i++){
            int cnt = 0;
            int left = 0;
            int right = arr.length-1;
            while(left < right){
                if(arr[left] % i == 0) cnt++;
                else break;
                
                if(arr[right] % i == 0) cnt++;
                else break;
                left++;
                right--;
            }
            if(left == right && arr.length % 2 == 1) {
                if(arr[left] % i == 0) cnt++;
            }
            if(cnt == arr.length) gcd = i;
        }
        return gcd;
    }
}
