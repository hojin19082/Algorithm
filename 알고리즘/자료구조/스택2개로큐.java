package ���ڵ�;
import java.util.*;
public class ����2����ť {

	static class stackQueue{
		Stack<Integer> in;
		Stack<Integer> out;
		
		stackQueue(){
			this.in = new Stack<>();
			this.out = new Stack<>();
		}
		//in stack���� data�� �׳� �־��ش�
		void inQueue(int data) {
			in.add(data);
		}
		
		//���� outQueue�� �����Ͱ� �ϳ��� ������
		//inStack�� �ִ� ��� �����͵��� �̾Ƽ� out�� �־��ָ�
		//inStack�� ���� ���Դ� data�� ���� �������� out�� �߰��˴ϴ�
		//���� out���� pop�� �ϸ� FIFO Ư���� ���� �� �ֽ��ϴ�.
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
