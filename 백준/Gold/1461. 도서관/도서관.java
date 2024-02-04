import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

   public static void main(String[] args) throws IOException {
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st=new StringTokenizer(br.readLine());
      
      int N=Integer.parseInt(st.nextToken());
      int M=Integer.parseInt(st.nextToken());
      ArrayList<Integer> subList_plus=new ArrayList<Integer>();
      ArrayList<Integer> subList_minus=new ArrayList<Integer>();
      int move=0;
      int mostFall=0;
      int max=0;
      
      st=new StringTokenizer(br.readLine());
      for(int i=0;i<N;i++)
      {
         int num=Integer.parseInt(st.nextToken());
         if(Math.abs(num)>max)
         {
            max=Math.abs(num);
            mostFall=num;
         }
         if(num<0)
            subList_minus.add(num);
         else
            subList_plus.add(num);
      }
      
      Collections.sort(subList_minus);
      Collections.sort(subList_plus,Collections.reverseOrder());
      
      for(int i=0;i<subList_minus.size();i+=M)
      {
    	 int num=subList_minus.get(i);
         if(num==mostFall)
        	 move+=Math.abs(num);
         else
        	 move+=Math.abs(num)*2;
      }
      for(int i=0;i<subList_plus.size();i+=M)
      {
    	 int num=subList_plus.get(i);
         if(num==mostFall)
        	 move+=Math.abs(num);
         else
        	 move+=Math.abs(num)*2;
      }
      
      System.out.println(move);
      
   }

}