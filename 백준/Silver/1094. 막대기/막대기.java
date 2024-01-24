import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		//int T=Integer.parseInt(br.readLine());
		
		//for(int test_case=1;test_case<=T;test_case++)
		//{
			int brick=64; //원래 가지고 있던 막대기
			int x=Integer.parseInt(br.readLine()); //만드려는 길이
			int sum=0; //막대 길이의 합
			Stack<Integer> stack=new Stack<Integer>();
			stack.add(brick); //스택에 원래 막대 입력
			sum+=64; //막대 길이의 합=원래 막대
			
			while(true) {
				if(sum==x) //막대 길이의 합=만드려는 길이
				{
					//sb.append("#").append(test_case).append(" ").append(stack.size()).append("\n");
					System.out.println(stack.size());
					break; //반복문 탈출
				}
				int num=stack.pop(); //스택에서 값 추출
				sum-=num; //스택에서 뺀 값만큼 막대 길이의 합도 뺌
				int n1=num/2; //이등분한 막대1
				int n2=num/2; //이등분한 막대2
				
				// 만약, 위에서 이등분한 막대 중 하나를 제외한 나머지의 모든 막대의 길이의 합이 Xcm보다 크거나 같다면
				if(sum+n1>=x) 
				{
					stack.add(n1); //조각을 하나만 스택에 추가 (제외한 조각을 버림)
					sum+=n1; //막대 길이의 합 갱신
				}
				//위에서 이등분한 막대 중 하나를 제외한 나머지의 모든 막대의 길이의 합이 Xcm보다 작다면
				else
				{
					//모든 조각 스택에 추가
					stack.add(n1); 
					stack.add(n2); 
					//합 갱신
					sum+=n1;
					sum+=n2;
				}
			}
			
		//}
		//결과 출력
		//System.out.println(sb);
	}

}