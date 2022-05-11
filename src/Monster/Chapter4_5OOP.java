package Monster;

import java.io.*;
import java.lang.*;
import java.math.BigInteger;
import java.util.*;

// 1000 1000 10000
public class Chapter4_5OOP {
	public static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		int nNumbers = scanner.nextInt();   // 배열의 원소의 수
		int nCommands = scanner.nextInt();  // 처리할 명령어의 수

		// Shift 연산이 가능한 배열을 선언하고 원소를 차례로 입력한다
		ShiftingArray<Integer> array = new ShiftingArray<>(nNumbers);
		for(int i = 0 ; i < nNumbers ; i ++)
		{
			array.set(i, scanner.nextInt());
		}

		// 각 명령어를 처리한다
		for(int i = 0 ; i < nCommands; i+= 1)
		{
			// 명령어 정보를 입력받는다
			int cmd = scanner.nextInt();
			if( cmd == 0 )
			{   // 현재 배열에 p번 인덱스에 있는 원소를 출력하는 명령
				int p = scanner.nextInt();
				int value = array.get(p);
				System.out.println(value);
			}else if(cmd == 1)
			{   // 현재 배열을 왼쪽으로 k번 shift하는 명령
				int k = scanner.nextInt();
				array.shiftLeft(k);
			}else if(cmd == 2)
			{   // 현재 배열을 오른쪽으로 k번 shift하는 명령
				int k = scanner.nextInt();
				array.shiftRight(k);
			}else if(cmd == 3)
			{   // 현재 배열을 최초의 위치로 복원하는 명령
				array.initializePosition();
			}
		}
	}
}



class ShiftingArray <T> {

	private final T[] array;        // 내부에 데이터를 저장할 배열
	public final int length;       // 배열의 길이
	public int leftIndex; // 시프트 한 크기를 저장하는 변수

	public ShiftingArray(int length)
	{
		this.length = length;
		this.array = (T[])(new Object[length]);
		this.leftIndex = 0;
	}

	/**
	 * 현재 배열에서 'index'번째에 존재하는 원소를 반환하는 함수
	 *
	 * @param index
	 * @return
	 */
	public T get(int index)
	{
//		leftIndex를 기준으로 떨어진 index이다
		int realindex = (leftIndex + index) % length;
		return array[realindex];
		
	}

	/**
	 * 현재 배열에서 'index'번째에 존재하는 원소를 'value'로 변경하는 함수
	 *
	 * @param index
	 * @param value
	 */
	public void set(int index, T value)
	{
		int realindex = (leftIndex + index) % length;
		array[realindex] = value;
	}

	/**
	 * 현재 배열의 모든 원소를 왼쪽으로 'times'번 이동하는 함수
	 * @param times
	 */
	public void shiftLeft(int times){
		times = times % length; // 의미는 배열을 일직선으로나열하면 순환구조가 생긴다. times는 length길이보다 커질수 있으므로 length안에 times를 넣야한다.
		leftIndex = (leftIndex + times) % length; // 이동한 값도 배열안에 넣기 위해 % length
	}

	/**
	 * 현재 배열의 모든 원소를 오른쪽으로 'times'번 이동하는 함수
	 *
	 * @param times
	 */
	public void shiftRight(int times){
		times = times % length; // times이 1000 이어도 length로 순환주기를 거르기때문에 length이내 값이다.
		leftIndex = (leftIndex - times + length) % length; // 오른쪽으로 쉬프트 연산을 한것은 왼쪽으로 포인터를 옮긴것과 같다.
		//times만큼 왼쪽으로 옮기면 음수가 발생할수 있다 + length
	}

	/**
	 * 현재 배열의 모든 원소를 가장 초기 위치로 되돌리는 함수
	 */
	public void initializePosition()
	{
		leftIndex = 0;
	}

}