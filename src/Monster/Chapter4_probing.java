package Monster;

import java.io.*;
import java.lang.*;
import java.util.*;

// 고객의 티켓을 배정해주는 자동 프로그램 완성하기

public class Chapter4_probing {
	public static final Scanner scanner = new Scanner(System.in);

	/**
	 *
	 * @param n     전체 티켓의 수
	 * @param m     요청 고객의 수
	 * @param ids   각 고객들의 회원번호
	 * @return
	 */
	public static ArrayList<Integer> getTicketNumbers(int n, int m, int[] ids)
	{
		ArrayList<Integer> tickets = new ArrayList<>();

		TicketTable table = new TicketTable(n);

		for(int ticket : ids){
			// 티켓 부여
			int number = table.findEmptyIndexByUserId(ticket);
			tickets.add(number);
			table.setUsed(number,true);// 사용확인 체크
		}
		
		return tickets;
	}

	public static void main(String[] args) throws Exception {
		int n = scanner.nextInt(); // 전체 티켓의 수
		int m = scanner.nextInt(); // 요청 고객의 수

		int[] ids = new int[m];

		for(int i = 0 ; i < m ; i ++)
		{
			ids[i] = scanner.nextInt();
		}

		ArrayList<Integer> tickets = getTicketNumbers(n, m, ids);

		for(int index : tickets){
			System.out.println(index);
		}
	}

}


class TicketTable
{
	private final boolean[] used; //티켓 사용 여부배열
	public final int length;

	public TicketTable(int length)
	{
		this.length = length;
		this.used = new boolean[length];
	}

	/**
	 * 사용자의 회원 번호로 지급받게 될 행운권 번호를 계산하는 메소드
	 */
	public int findEmptyIndexByUserId(int userId)
	{
		// 고객번호를 기준으로 % 배열의 길이로 나누어서 티켓번호를 부여한다
		int number = userId%length;
		// 부여한 티켓번호가 사용된 티켓이면 오른쪽 방향으로 +1 하여 티켓을 사용한다
		while(isUsed(number) == true){
			number = (number + 1) % length;
			
			 /* n-1까지 확인 하고 0부터 다시 순환한다. , 이것을 안적어줘도 된다 왜? := number-1 이 사용한 티켓이라면+ 1하여  n, length도 n%n == 0 이므로 순환이 된다.
				if(number == length-1){
				 	number = 0;
			 	
			 	}
			 
			 */
		}
		// n-1까지 확인 하고 0부터 다시 순환한다.
		return number; // := 여기까지 도달하면 사용가능한 티켓을 찾은것
	}

	/**
	 * 해당 행운권 번호가 이미 사용 중인지 여부를 반환하는 메소드
	 */
	public boolean isUsed(int ticketIndex)
	{
		return used[ticketIndex]; // true := 사용한 티켓, false := 사용가능한 티켓
	}

	/**
	 *  티켓 사용 여부를 갱신하기 위한 메소드
	 */
	public void setUsed(int index, boolean status)
	{
		used[index] = status; // 티켓 사용여부 체크확인
	}
}
