import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        long[] A=new long[N];
        long ans=N;
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            A[i]=Long.parseLong(st.nextToken());
        st=new StringTokenizer(br.readLine());
        Long B=Long.parseLong(st.nextToken());
        long C=Long.parseLong(st.nextToken());

        for(int i=0;i<N;i++)
        {
            A[i]=A[i]-B;
            if(A[i]>0)
            {
                ans+=A[i]/C;
                if(A[i]%C>0)
                    ans++;
            }
        }
        System.out.println(ans);  
    }
}