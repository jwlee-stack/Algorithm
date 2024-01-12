import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static class NODE implements Comparable<NODE>
    {
        int arrive;
        int weight;
        NODE(int arrive, int weight)
        {
            this.arrive=arrive;
            this.weight=weight;
        }

        @Override
        public int compareTo(NODE O)
        {
            return this.weight-O.weight;
        }
    }
    
    public static ArrayList[] list;
    public static int[] result;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int V=Integer.parseInt(st.nextToken());
        int E=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(br.readLine())-1;
        int max=Integer.MAX_VALUE;

        result=new int[V];
        Arrays.fill(result,max);
        result[K]=0;
        
        list=new ArrayList[V];
        for(int i=0;i<list.length;i++)
            list[i]=new ArrayList<NODE>();

        for(int i=0;i<E;i++)
        {
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken())-1;
            int arrive=Integer.parseInt(st.nextToken())-1;
            int weight=Integer.parseInt(st.nextToken());

            list[start].add(new NODE(arrive,weight));
        }

        Dijkstra(K);

        for(int i=0;i<result.length;i++)
        {
            if(result[i]==max)
                System.out.println("INF");
            else
                System.out.println(result[i]);
        }
    }
    public static void Dijkstra(int startNode)
    {
        PriorityQueue<NODE> que=new PriorityQueue<NODE>();
        result[startNode]=0;
        que.add(new NODE(startNode,0));

        while(!que.isEmpty())
        {
            NODE node=que.remove();
            int arrive=node.arrive;
            int weight=node.weight;
            
            if(weight>result[arrive])
                continue;
            
            for(int i=0;i<list[arrive].size();i++)
            {
                NODE nextNode=(NODE) list[arrive].get(i);
                if(result[nextNode.arrive]>weight+nextNode.weight)
                {
                    result[nextNode.arrive]=weight+nextNode.weight;
                    que.add(new NODE(nextNode.arrive,result[nextNode.arrive]));
                }    
            }
        }
    }
}