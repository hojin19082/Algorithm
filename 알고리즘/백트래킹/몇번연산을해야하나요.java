package ��Ʈ��ŷ;
public class ����������ؾ��ϳ��� {
	//num�� target�� �� �ּ� ����
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
