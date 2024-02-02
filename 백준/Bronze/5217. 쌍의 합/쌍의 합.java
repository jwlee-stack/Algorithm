import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] arr=new int[N];
        Queue<Integer> a=new LinkedList<>();
        Queue<Integer> b=new LinkedList<>();
        
        for(int i=0;i<N;i++)
            arr[i]=Integer.parseInt(br.readLine());
        
        for(int i=0;i<N;i++)
        {
            System.out.print("Pairs for "+arr[i]+": ");
            for(int t=0,j=1,k=arr[i]-1;t<arr[i]/2;t++,j++,k--)
            {
                if(j==k) break;
                a.add(j);
                b.add(k);
            }
            while(!a.isEmpty())
            {
                if(a.size()==1)
                    System.out.print(a.remove()+" "+b.remove());
                else
                    System.out.print(a.remove()+" "+b.remove()+", ");
            }
            System.out.println();
        }
    }
}