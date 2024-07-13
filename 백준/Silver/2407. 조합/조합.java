import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int r=Integer.parseInt(st.nextToken());
        int result=0;
        BigInteger parent=Factorial(r).multiply(Factorial(n-r));
        BigInteger child=Factorial(n);
        System.out.println(child.divide(parent));
    }
    public static BigInteger Factorial(int num)
    {
        if(num==1)
        {
            return new BigInteger("1");
        }
        return new BigInteger(Integer.toString(num)).multiply(Factorial(num-1));
    }
    
}