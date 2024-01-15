
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int arr[]=new int[N+1];
		int num=0; 
		boolean hansu=true;
		int difference=0;
		int before=0;
		int now=0;
		for(int i=1;i<=N;i++) //N만큼 반복
		{
			arr[i]=i;
			String value=Integer.toString(arr[i]); //숫자
			
			if(value.length()==1) //숫자 길이가 1(1의 자리)
			{
				num++;continue;
			}
			else //숫자 길이가 1 초과
			{
				difference=(value.charAt(0)-'0')-(value.charAt(1)-'0'); //등차 저장
			}
			
			for(int j=1;j<value.length();j++) //숫자의 자릿수만큼 반복
			{	
				before=value.charAt(j-1)-'0'; //이전 값
				now=value.charAt(j)-'0'; //지금 값

				if(difference==(before-now)) //둘의 차이가 등차와 같음
				{
					hansu=true;
				}
				else //둘의 차이가 등차와 다름
				{
					hansu=false;
					break;
				}
			}
			
			if(hansu==true) //모든 차이가 등차와 같았음
				num++;
		}
		System.out.println(num);
		
	}

}
