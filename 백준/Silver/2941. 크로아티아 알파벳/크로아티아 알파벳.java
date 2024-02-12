import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        int answer=0;
        for(int i=0;i<str.length();i++)
        {
            char first=str.charAt(i);
            if(i!=str.length()-1)
            {
                char second=str.charAt(i+1);
                if((first=='c'&&second=='=')||(first=='c'&&second=='-')||
                   (first=='d'&&second=='-')||(first=='l'&&second=='j')||
                   (first=='n'&&second=='j')||(first=='s'&&second=='=')||
                   (first=='z'&&second=='='))
                i++;
                else if(first=='d'&&second=='z'&&i<str.length()-2&&str.charAt(i+2)=='=')
                i+=2;
            }
            answer++;
        }
        System.out.println(answer);
    }
}