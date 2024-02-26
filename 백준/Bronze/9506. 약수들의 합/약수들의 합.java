import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        while(true)
        {
            int n=Integer.parseInt(br.readLine());
            if(n==-1) break;
            Queue<Integer> que=new LinkedList<>();
            int sum=1;
            
            for(int i=2;i<n;i++)
            {
                if(n%i==0)
                {
                    que.add(i);
                    sum+=i;
                }
            }
            if(sum==n)
            {
                System.out.print(n+" = 1 + ");
                while(!que.isEmpty())
                {
                    int num=que.remove();
                    if(que.size()==0)
                        System.out.print(num);
                    else
                        System.out.print(num+" + ");
                }
                System.out.println();
            }
            else
                System.out.println(n+" is NOT perfect.");
        }
    }
}