import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken()); //신청한 동아리의 수 
		int S=Integer.parseInt(st.nextToken()); //팀원 3명의 능력 합에 대한 스마트클럽 가입 조건
		int M=Integer.parseInt(st.nextToken()); //개인 능력치에 대한 스마트클럽 가입 조건
		int num=0; //스마클럽 가입이 가능한 동아리의 수
		
		for(int i=0;i<N;i++) //신청한 동아리의 수만큼 반복
		{
			st=new StringTokenizer(br.readLine());
			
			int member1=Integer.parseInt(st.nextToken()); //동아리의 팀원1의 능력치
			int member2=Integer.parseInt(st.nextToken()); //동아리의 팀원2의 능력치
			int member3=Integer.parseInt(st.nextToken()); //동아리의 팀원3의 능력치
					
			if(member1<M||member2<M||member3<M) //어느 누구라도 최소 개인 능력치를 만족하지 못하면
				continue; 
			if(member1+member2+member3<S) //팀원 3명의 능력합이 스마트클럽 가입조건을 만족하지 못하면
				continue;
			//모든 조건 만족
			num++; //가입이 가능한 동아리 개수+1
			
			sb.append(member1).append(" ").append(member2).append(" ").append(member3).append(" ");
		}
		
		System.out.println(num);
		System.out.println(sb); //출력
		
	}

}