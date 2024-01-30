import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static class HEDGEHOG
    {
        int x;
        int y;
        HEDGEHOG(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
    }
    public static class WATER
    {
        int x;
        int y;
        WATER(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
    }
    public static char[][] arr;
    public static int[] dr={-1,1,0,0};
    public static int[] dc={0,0,-1,1};
    public static int result=0;
    public static boolean[][] Hvisited;
    public static boolean[][] Wvisited;
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int R=Integer.parseInt(st.nextToken());
        int C=Integer.parseInt(st.nextToken());
        arr=new char[R][C];
        Hvisited=new boolean[R][C];
        Wvisited=new boolean[R][C];
        
        HEDGEHOG hedgehog=new HEDGEHOG(0,0);
        ArrayList<WATER> water=new ArrayList<>();
        
        for(int i=0;i<R;i++)
        {
            String str=br.readLine();
            for(int j=0;j<C;j++)
            {
                arr[i][j]=str.charAt(j);
                if(arr[i][j]=='*') //water
                {
                    water.add(new WATER(i,j));
                }
                else if(arr[i][j]=='S') //hedgehog
                {
                    hedgehog=new HEDGEHOG(i,j);
                }
            }
        }
        if(bfs(hedgehog, water, R, C))
            System.out.println(result);
        else
           System.out.println("KAKTUS"); 
    }
    public static boolean bfs(HEDGEHOG hedgehog, ArrayList<WATER> waters, int R, int C)
    {
        Queue<HEDGEHOG> Hque=new LinkedList<>();
        Queue<WATER> Wque=new LinkedList<>();

        Hque.add(hedgehog);
        for(int i=0;i<waters.size();i++)
        {
            Wque.add(waters.get(i));
        }
        while(!Hque.isEmpty())
        {
            //고슴도치 이동
            int Hsize=Hque.size();
            for(int t=0;t<Hsize;t++)
            {
                hedgehog=Hque.remove();
                int hogX=hedgehog.x;
                int hogY=hedgehog.y;
                
                for(int i=0;i<4;i++)
                {
                    int nextHogX=hogX+dr[i];
                    int nextHogY=hogY+dc[i];

                    if(range(nextHogX,nextHogY,R,C)&&!Hvisited[nextHogX][nextHogY])
                    {
                        if(arr[nextHogX][nextHogY]=='.'&&!waterAround(nextHogX,nextHogY,R,C))
                        {
                            Hvisited[nextHogX][nextHogY]=true;
                            arr[nextHogX][nextHogY]='S';
                            Hque.add(new HEDGEHOG(nextHogX,nextHogY));
                        }
                        else if(arr[nextHogX][nextHogY]=='D')
                        {
                            result++;
                            return true;
                        }
                    }
                }
            }
            
            //물 차오름
            int Wsize=Wque.size();
            for(int t=0;t<Wsize;t++)
            {
                WATER water=Wque.remove();
                int waterX=water.x;
                int waterY=water.y;
                for(int i=0;i<4;i++)
                {
                    int nextWaterX=waterX+dr[i];
                    int nextWaterY=waterY+dc[i];

                    if(range(nextWaterX,nextWaterY,R,C)&&(arr[nextWaterX][nextWaterY]=='.'||arr[nextWaterX][nextWaterY]=='S')&&!Wvisited[nextWaterX][nextWaterY])
                    {
                        Wvisited[nextWaterX][nextWaterY]=true;
                        arr[nextWaterX][nextWaterY]='*';
                        Wque.add(new WATER(nextWaterX,nextWaterY));
                    }
                }
            }
            
            result++;
        }
        return false;
    }
    public static boolean range(int x, int y,int R, int C)
    {
        if(x>=0&&x<R&&y>=0&&y<C)
            return true;
        else
            return false;
    }
    public static boolean waterAround(int x, int y,int R,int C)
    {
        for(int i=0;i<4;i++)
        {
            int nextX=x+dr[i];
            int nextY=y+dc[i];
            if(range(nextX,nextY,R,C)&&arr[nextX][nextY]=='*')
                return true;
        }
        return false;
    }
    
}