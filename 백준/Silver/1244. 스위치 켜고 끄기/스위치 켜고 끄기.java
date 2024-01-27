
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int size=sc.nextInt(); //스위치 크기
		int[] arr=new int[size]; //스위치 배열
		int switch_num=0;
		int student=0; //학생 수
		int sex=0; //성별
		
		for(int i=0;i<size;i++) //스위치 배열 초기화
			arr[i]=sc.nextInt();
		
		student=sc.nextInt(); //학생 수 입력
		
		for(int i=0;i<student;i++)
		{
			sex=sc.nextInt(); //학생 (남녀)
			switch_num=sc.nextInt(); //스위치 번호
			
			if(sex==1) //남학생
			{
				for(int j=1;switch_num*j-1<size;j++)
					arr[switch_num*j-1]=arr[switch_num*j-1]==0? 1:0;
			}
			else if(sex==2) //여학생
			{	int check=0;
				for(int j=1;switch_num-1-j>=0&&switch_num-1+j<size;j++) //앞 뒤 대칭 처음~끝까지 탐색
				{
					if(arr[switch_num-1-j]==arr[switch_num-1+j]) //앞뒤 대칭끼리 같음
						check++; //바꿔야 할 대칭 개수
					else 										//앞 뒤 대칭끼리 다름
						break;
				}
				
				for(int j=0;j<=check;j++) //바꿔야 할 대칭 개수+1 만큼 반복 (자기 자신도 바꾸므로)
				{
					arr[switch_num-1-j]=arr[switch_num-1-j]==0?1:0;
					if(j!=0)
					arr[switch_num-1+j]=arr[switch_num-1+j]==0?1:0;
				}
			}
		}
		for(int i=0;i<arr.length;i++) //결과 출력
		{	
			if(i<19)
				System.out.print(arr[i]+" ");
			else
				System.out.println(arr[i]);
		}
	}

}
