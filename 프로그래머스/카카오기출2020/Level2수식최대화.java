package 카카오기출2020;
import java.util.ArrayList;
public class Level2수식최대화 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String expression = "100-200*300-500+20";
		long answer = Long.MIN_VALUE;
		String op[][] = {{"+", "*", "-"},{"+", "-", "*"},{"-","*","+"},
				{"-","+","*"},{"*","+","-"},{"*","-","+"}};
		ArrayList<String> list = new ArrayList<>();
		int start = 0;
		for(int i=0; i<expression.length(); i++) {
			if(expression.charAt(i) == '-' || expression.charAt(i) == '+' ||
					expression.charAt(i) == '*') {
				list.add(expression.substring(start, i));
				list.add(expression.charAt(i) +"");
				start = i+1;
			}
		}
		list.add(expression.substring(start));
		
		for(int i=0; i<op.length; i++) {
			ArrayList<String> sub_list = new ArrayList<String>(list);
			for(int j=0; j<3; j++) {
				for(int k=0; k<sub_list.size(); k++) {
					if(op[i][j].equals(sub_list.get(k))) {
						sub_list.set(k-1, calc(sub_list.get(k-1), sub_list.get(k), sub_list.get(k+1)));
						sub_list.remove(k);
						sub_list.remove(k);
						k--;
					}
				}
			}
			answer = Math.max(answer, Math.abs(Long.parseLong(sub_list.get(0))));
		}
		System.out.println(answer);
	}
	public static String calc(String num1, String op, String num2) {
		long n1 = Long.parseLong(num1);
		long n2 = Long.parseLong(num2);
		
		if(op.equals("+")) {
			return n1+n2+"";
		}else if(op.equals("-")) {
			return n1-n2 + "";
		}
		return n1 * n2 +"";
	}

}
