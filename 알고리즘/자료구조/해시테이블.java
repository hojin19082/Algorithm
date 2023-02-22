package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 해시테이블 {

   public static void main(String[] args) throws IOException{
      // TODO Auto-generated method stub
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] str = br.readLine().split(" ");
      int M = Integer.parseInt(str[0]);
      int N = Integer.parseInt(str[1]);
      Hashtable<String, String> h = new Hashtable<>();
      
      for(int i=0; i<M; i++) {
         String[] arr = br.readLine().split(" ");
         h.put(arr[0], arr[1]);
      }
      
      for(int i=0; i<N; i++) {
         String s = br.readLine();
         System.out.println(h.get(s));
      }
      
   }

}