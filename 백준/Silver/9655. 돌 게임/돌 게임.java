import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        
        //상근이 승리->true
        boolean[] dp=new boolean[1001];
        dp[1]=true;
        dp[2]=false;
        dp[3]=true;

        if(N>=4)
        {
            for(int i=4;i<N+1;i++)
                //전판에 돌을 1개 가져갔든, 3개 가져갔든 둘 다 상근이가 이겼으면 이번판은 창영이 승리. 이외는 상근이 승리
                dp[i]=(dp[i-1]&&dp[i-3])?false:true;        
        }
        
        String result=dp[N]?"SK":"CY";
        System.out.print(result);
    }
}