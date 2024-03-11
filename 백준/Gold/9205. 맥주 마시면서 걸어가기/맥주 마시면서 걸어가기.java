import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static class NODE
    {
        int x;
        int y;
        boolean visit;
        
        NODE(int x, int y, boolean visit)
        {
            this.x=x;
            this.y=y;
            this.visit=visit;
        }
    }
    public static NODE[] nodes;
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        int T=Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++)
        {
            int n=Integer.parseInt(br.readLine());
            nodes=new NODE[n+2];
            for(int i=0;i<n+2;i++)
            {
                StringTokenizer st=new StringTokenizer(br.readLine());
                int x=Integer.parseInt(st.nextToken());
                int y=Integer.parseInt(st.nextToken());
                nodes[i]=new NODE(x,y,false);
            }
            if(bfs(n))
                System.out.println("happy");
            else
                System.out.println("sad");
        }
    }
    public static boolean bfs(int n)
    {
        Queue<NODE> que=new LinkedList<>();
        que.add(nodes[0]);

        while(!que.isEmpty())
        {
            NODE node=que.remove();
            int x=node.x;
            int y=node.y;

            for(int i=1;i<n+2;i++)
            {
                NODE next=nodes[i];
                int nextX=next.x;
                int nextY=next.y;
                boolean nextV=next.visit;
                if(!nextV&&InRange(x,y,nextX,nextY))
                {
                    if(i==n+1) return true;
                    next.visit=true;
                    que.add(next);
                }
            }
        }
        return false;
    }
    public static boolean InRange(int x, int y, int nextX, int nextY)
    {
        int len=Math.abs(x-nextX)+Math.abs(y-nextY);
        if(len<=1000) 
            return true;
        else 
            return false;
    }
}