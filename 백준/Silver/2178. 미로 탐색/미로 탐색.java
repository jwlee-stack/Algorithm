import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static int[][] arr;
    public static boolean[][] visited;
    public static int[] dr={-1,1,0,0}; //상하좌우
    public static int[] dc={0,0,-1,1}; //상하좌우
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        arr=new int[n][m];
        visited=new boolean[n][m];
        for(int i=0;i<n;i++)
        {
            String[] str=br.readLine().split("");
            for(int j=0;j<m;j++) 
                arr[i][j]=Integer.parseInt(str[j]);
        }

        System.out.println(bfs(0,0,n,m));
    }
    public static int bfs(int startX,int startY, int n, int m)
    {
        int result=0;
        Queue<Integer> que=new LinkedList<Integer>();
        que.add(startX);
        que.add(startY);

        while(!que.isEmpty())
        {
            int size=que.size();
            while(size>0)
            {
                int x=que.remove();
                int y=que.remove();
                if(x==n-1&&y==m-1) return result+1;
                
                for(int i=0;i<4;i++)
                {
                    int newX=x+dr[i];
                    int newY=y+dc[i];
                    if(newX>=0&&newX<n&&newY>=0&&newY<m&&!visited[newX][newY]&&arr[newX][newY]==1)
                    {
                        visited[newX][newY]=true;
                        que.add(newX);
                        que.add(newY);
                    }
                }
                size-=2;
            }
            result++;
        }
        return -1;
    }
}