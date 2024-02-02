import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static ArrayList<Integer>[] arr;
    public static boolean[] visited;
    public static int[] result;
    public static int dfs_depth=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        HashSet<Integer> set=new HashSet<>();
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int V=Integer.parseInt(st.nextToken())-1;

        result=new int[N];
        arr=new ArrayList[N];
        for(int i=0;i<N;i++)
            arr[i]=new ArrayList<Integer>();
        
        for(int i=0;i<M;i++)
        {
            st=new StringTokenizer(br.readLine());
            int point1=Integer.parseInt(st.nextToken())-1;
            int point2=Integer.parseInt(st.nextToken())-1;
            arr[point1].add(point2);
            arr[point2].add(point1);
            set.add(point1);
            set.add(point2);
        }

        for(int i=0;i<N;i++)
            Collections.sort(arr[i]);
        
        visited=new boolean[N];
        dfs(V,set.size()-1);
        System.out.println();
        
        visited=new boolean[N];
        bfs(V);
        
    }
    public static void dfs(int node,int last)
    {
        result[dfs_depth++]=node;
        visited[node]=true;
        System.out.print((node+1)+" ");
        
        for(int i=0;i<arr[node].size();i++)
        {
            int nextNode=arr[node].get(i);
            
            if(!visited[nextNode])
                dfs(nextNode,last);
        }
    }
    public static void bfs(int start)
    {
        Queue<Integer> que=new LinkedList<>();
        que.add(start);
        visited[start]=true;
        int bfs_depth=0;
        
        while(!que.isEmpty())
        {
            int node=que.remove();
            result[bfs_depth++]=node;
            
            for(int i=0;i<arr[node].size();i++)
            {
                int nextNode=arr[node].get(i);
                if(!visited[nextNode])
                {
                    visited[nextNode]=true;
                    que.add(nextNode);
                }
            }
        }
        
        Print(bfs_depth-1);
    }
    public static void Print(int depth)
    {
        for(int i=0;i<=depth;i++)
        {
            result[i]++;
            if(i==depth)
                System.out.println(result[i]);
            else
                System.out.print(result[i]+" ");
        }
    }
}