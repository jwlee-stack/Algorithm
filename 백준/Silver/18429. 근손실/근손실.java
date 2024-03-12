import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static int[] arr;
    public static int answer=0;
    public static boolean visited[];
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        visited=new boolean[N];

        arr=new int[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
        {
            arr[i]=Integer.parseInt(st.nextToken())-K;
        }
        perm(0,0,N);
        System.out.println(answer);
    }
    public static void perm(int depth,int sum,int N)
    {
        if(depth==N)
        {
            answer++;
            return;
        }
        if(sum<0)
        {
            return;
        }
        for(int i=0;i<N;i++)
        {
            if(!visited[i])
            {
                visited[i]=true;
                perm(depth+1,sum+arr[i],N);
                visited[i]=false;
            }
        }
    }
}