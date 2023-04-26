package 백트래킹;
public class 몇번연산을해야하나요 {
	//num이 target이 될 최소 연산
		static int answer = Integer.MAX_VALUE;
		public int solution(int number, int target) {
			checkCal(number, target, 0);
			return answer;
		}
		public static void checkCal (int num, int target, int count){
			if(num == target){
				answer = Math.min(num, count);
				return;
			}
			if(answer>= count) checkCal(num+1, target, count+1);
			if(answer>= count) checkCal(num-1, target, count+1);
			if(answer>= count) checkCal(num*2, target, count+1);
		}

}
