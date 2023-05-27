package 손코딩;
import java.util.*;
public class 스택2개로큐 {

	static class stackQueue{
		Stack<Integer> in;
		Stack<Integer> out;
		
		stackQueue(){
			this.in = new Stack<>();
			this.out = new Stack<>();
		}
		//in stack에는 data를 그냥 넣어준다
		void inQueue(int data) {
			in.add(data);
		}
		
		//만약 outQueue에 데이터가 하나도 없으면
		//inStack에 있는 모든 데이터들을 뽑아서 out에 넣어주면
		//inStack에 먼저 들어왔던 data가 가장 마지막에 out에 추가됩니다
		//따라서 out에서 pop을 하면 FIFO 특성을 가질 수 있습니다.
		int outQueue() {
			if(in.isEmpty()) return 0;
			if(out.isEmpty()) {
				while(!in.isEmpty()) {
					out.add(in.pop());
				}
			}
			return out.pop();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stackQueue sq = new stackQueue();
		sq.inQueue(1);
		sq.inQueue(2);
		System.out.println(sq.outQueue());
		System.out.println(sq.outQueue());
	}

}
