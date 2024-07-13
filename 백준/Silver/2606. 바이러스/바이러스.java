import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int nodeNum=Integer.parseInt(br.readLine());
        int line=Integer.parseInt(br.readLine());
        int result=0;

        //부모 배열 초기화
        int[] parent=new int[nodeNum];
        for(int i=0;i<nodeNum;i++)
            parent[i]=i;

        //노드 관계 입력
        for(int i=0;i<line;i++)
        {
            StringTokenizer st=new StringTokenizer(br.readLine());
            int node1=Integer.parseInt(st.nextToken())-1;
            int node2=Integer.parseInt(st.nextToken())-1;
            unionParent(parent,node1,node2);
        }

        //부모관계 갱신
        for(int i=0;i<nodeNum;i++)
        {
            getParent(parent,i);
        }
        
        //같은 부모 몇 개인지 탐색
        for(int i=1;i<nodeNum;i++)
        {
            if(findParent(parent,0,i)) 
                result++;
        }
        System.out.print(result);
    }
    //노드들 유니온 맺기(같은 부모로 설정)
    public static void unionParent(int[] parent,int node1, int node2)
    {
        node1=getParent(parent,node1);
        node2=getParent(parent,node2);
        if(node1>node2)
            parent[node1]=node2;
        else
            parent[node2]=node1;
        
        /*if(getParent(parent,node1)>getParent(parent,node2))
            parent[node1]=getParent(parent,node2);
        else
            parent[node2]=getParent(parent,node1);
        System.out.println(Arrays.toString(parent));*/
    }
    //노드의 부모 찾기
    public static int getParent(int[] parent,int node)
    {
        
        if(parent[node]==node) return node;
        return parent[node]=getParent(parent,parent[node]);
    }
    //두 노드가 같은 부모인지 확인하기
    public static boolean findParent(int[] parent,int node1, int node2)
    {
        if(getParent(parent,node1)==getParent(parent,node2))
            return true;
        else
            return false;
    }
}