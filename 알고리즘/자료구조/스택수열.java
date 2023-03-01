package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 스택수열 {

	public static void main(String[] args) throws IOException{
	      // TODO Auto-generated method stub
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      Stack<Integer> stack = new Stack<>();
	      StringBuilder sb = new StringBuilder();
	      
	      int t = Integer.parseInt(br.readLine());
	      int start = 0;
	      
	      for(int i=1; i<=t; i++) {
	    	  int num = Integer.parseInt(br.readLine());
	    	  if(num > start) {
	    		  for(int j=start+1; j<=num; j++) {
	    			  stack.push(j);
	    			  sb.append('+').append('\n');
	    		  }
	    		  start = num;
	    	  }else if(stack.peek()!=num) {
	    		  System.out.println("NO");
	    		  return;
	    	  }
	    	  stack.pop();
	    	  sb.append('-').append('\n');
	      }
	      System.out.println(sb.toString());
	      
	}

}
