import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static int[] T;
    public static int[] P;
    public static int ans=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        T=new int[N];
        P=new int[N];

        for(int i=0;i<N;i++)
        {
            StringTokenizer st=new StringTokenizer(br.readLine());
            T[i]=Integer.parseInt(st.nextToken());
            P[i]=Integer.parseInt(st.nextToken());
        }
        dfs(0,0,N);
        System.out.println(ans);
    }
    public static void dfs(int depth,int result,int N)
    {
        if(depth>=N)
        {
            ans=Math.max(ans,result);
            return;
        }
        for(;depth<N;depth++)
        {
            int length=T[depth];
            int nextIdx=depth+length;
            
            if(nextIdx<=N)
            {
                result+=P[depth];
                dfs(nextIdx,result,N);
                result-=P[depth];
            }
            else
                dfs(nextIdx,result,N);
        }

    }
}