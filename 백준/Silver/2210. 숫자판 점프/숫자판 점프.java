import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static String[][] arr=new String[5][5];
    public static int[] dr={-1,1,0,0};
    public static int[] dc={0,0,-1,1};
    public static HashSet<String> set=new HashSet<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<5;i++)
        {
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++)
            {
                arr[i][j]=st.nextToken();
            }
        }
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                dfs(i,j,0,"");
            }
        }
        System.out.println(set.size());
    }
    public static void dfs(int x,int y,int depth,String str)
    {
        if(depth==6)
        {
            set.add(str);
            return;
        }
        str+=arr[x][y];
        for(int i=0;i<4;i++)
        {
            int newX=x+dr[i];
            int newY=y+dc[i];
            if(newX>=0&&newX<5&&newY>=0&&newY<5)
            {
                dfs(newX,newY,depth+1,str);
            }
        }
    }
}