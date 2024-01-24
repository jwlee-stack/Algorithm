import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static char[][] arr;
    public static boolean[][] visited;
    public static int result=0;
    public static int[] dr={-1,0,1}; //우상,우,우하 
    public static int[] dc={1,1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int R=Integer.parseInt(st.nextToken());
        int C=Integer.parseInt(st.nextToken());
        arr=new char[R][C];
        visited=new boolean[R][C];
        
        for(int i=0;i<R;i++)
        {
            String str=br.readLine();
            for(int j=0;j<C;j++)
            {
                arr[i][j]=str.charAt(j);
            }
        }

        for(int i=0;i<R;i++)
        {
            dfs(i,0,R,C);
        }
        System.out.println(result);
    }
    public static boolean dfs(int x,int y,int R, int C)
    {
        visited[x][y]=true;
        if(y==C-1)
        {
            result++;
            return true;
        }

        for(int i=0;i<3;i++)
        {
            int nextX=x+dr[i];
            int nextY=y+dc[i];

            if(nextX>=0&&nextX<R&&nextY>=0&&nextY<C&&!visited[nextX][nextY]&&arr[nextX][nextY]=='.')
            {
                if(dfs(nextX,nextY,R,C))
                {
                    return true;
                }
            }
        }
        return false;
    }
}