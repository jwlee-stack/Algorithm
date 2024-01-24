import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static char[] arr;
    public static char[] result;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int L=Integer.parseInt(st.nextToken());
        int C=Integer.parseInt(st.nextToken());
        arr=new char[C];
        result=new char[L];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<C;i++)
            arr[i]=st.nextToken().charAt(0);

        Arrays.sort(arr);
        comb(L,C,0,0);
    }
    public static void comb(int r,int n,int depth,int start)
    {
        if(depth==r)
        {
            if(CHK())
                Print();
            return;
        }
        for(int i=start;i<n;i++)
        {
            result[depth]=arr[i];
            comb(r,n,depth+1,i+1);
        }
    }
    public static boolean CHK()
    {
        int consonant=0;
        int vowel=0;
        for(int i=0;i<result.length;i++)
        {
            if(result[i]=='a'||result[i]=='e'||result[i]=='i'||result[i]=='o'||result[i]=='u')
                vowel++;
            else
                consonant++;
        }
        if(vowel>0&&consonant>1)
            return true;
        else
            return false;
    }
    public static void Print()
    {
        for(int i=0;i<result.length;i++)
            System.out.print(result[i]);
        System.out.println();
    }
}