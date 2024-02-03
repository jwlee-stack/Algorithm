import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int N=Integer.parseInt(br.readLine());
        Queue<Integer> a=new LinkedList<>();
        Queue<Integer> b=new LinkedList<>();
        
        for(int i=0;i<N;i++)
        {
            int num=Integer.parseInt(br.readLine());
            sb.append("Pairs for ").append(num).append(": ");
            for(int t=0,j=1,k=num-1;t<num/2;t++,j++,k--)
            {
                if(j==k) break;
                a.add(j);
                b.add(k);
            }
            while(!a.isEmpty())
            {
                sb.append(a.remove()).append(" ").append(b.remove());
                if(a.size()>0)
                    sb.append(", ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}