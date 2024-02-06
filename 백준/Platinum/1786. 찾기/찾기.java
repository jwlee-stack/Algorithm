import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static int num=0;
    public static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String T=br.readLine();
        String P=br.readLine();

        kmp(T,P);
        System.out.printf("%d\n%s",num,sb.toString());
    }
    public static void kmp(String T, String P)
    {
        int[] pi=getpi(P);
        int Tsize=T.length();
        int Psize=P.length();

        for(int i=0,j=0;i<Tsize;i++)
        {
            while(j>0&&T.charAt(i)!=P.charAt(j))
                j=pi[j-1];
            
            if(T.charAt(i)==P.charAt(j))
            {
                if(j==Psize-1)
                {
                    num++;
                    sb.append((i+1)-Psize+1).append(" ");
                    j=pi[j];
                }
                else
                    j++;
            }
        }
    }
    public static int[] getpi(String P)
    {
        int size=P.length();
        int[] pi=new int[size];

        for(int i=1,j=0;i<size;i++)
        {
            while(j>0&&P.charAt(i)!=P.charAt(j))
                j=pi[j-1];
            
            if(P.charAt(i)==P.charAt(j))
                pi[i]=++j;
        }
        return pi;
    }
}