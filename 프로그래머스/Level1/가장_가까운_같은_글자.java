package Level1;

public class 가장_가까운_같은_글자 {

	public int[] solution(String s) {
        int[] arr = new int[26];
        for(int i=0; i<26; i++){
            arr[i] = -1;
        }
        char[] chr = s.toCharArray();
        int[] answer = new int[chr.length];
        for(int i=0; i<chr.length; i++){
            if(arr[chr[i] - 'a'] == -1){
                answer[i] = -1;
            }else{
                answer[i] = i-arr[chr[i] - 'a'];
            }
            arr[chr[i] - 'a'] = i;
        }
        return answer;
    }

}
