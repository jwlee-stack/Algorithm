import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++)
        {
            int n=Integer.parseInt(br.readLine());
            answer=0;
            dfs(0,n);
            System.out.println(answer);
        }
    }
    public static void dfs(int sum,int n)
    {
        if(sum>n)
            return;
        if(sum==n)
        {
            answer++;
            return;
        }

        for(int i=1;i<=3;i++)
            dfs(sum+i,n);
    }
}