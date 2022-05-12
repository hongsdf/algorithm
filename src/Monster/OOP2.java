package Monster;


import java.io.*;
import java.lang.*;
import java.math.BigInteger;
import java.util.*;

// 1000 1000 10000
public class OOP2 {
	public static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		int nNumbers = scanner.nextInt();   // 배열의 원소의 수
		int nCommands = scanner.nextInt();  // 처리할 명령어의 수

		// Shift 연산이 가능한 배열을 선언하고 원소를 차례로 입력한다
		ShiftingArray1<Integer> array = new ShiftingArray1<>(nNumbers);
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


// 객체 지향 만들기
// 새로운 클래스에 타입을 설정할때는 제네릭을 이용한다
class ShiftingArray1 <T> {
	final int length; // 길이는 변하지 않는다.
	//배열을 생성
	private final T arr[]; // 변하지 않고 외부에서 접근 할수 없다.
	int leftIndex = 0; // 직접배열을 옮기지 않고 포인터로 접근하기 위한 방법
	
	//생성자
	ShiftingArray1(int length){
		this.length = length;
		this.arr = (T[])(new Object[length]);
		this.leftIndex = 0;
	}




	public T get(int index) {
		// realIndex := 배열을 쉬프트연산을 수행하면 결과로 leftIndex 포인터의 값을 반환하는 것이다. 하지만 현재 포인터의값에서 해당 index값을
		// 반환하기 위해서는 leftIndex로부터 + index떨어진 값일것이다. 더하면 범위를 초과 할 수 있어 나머지 연산수행
		int realIndex = (index + leftIndex) % length; 
		return arr[realIndex];
	}
	// private 배열에 접근 하기 위한 public set메서드
	public void set(int index, T value) {
		int real = ( index + leftIndex ) % length;
		arr[real] = value;
		
	}
	
	public void shiftLeft(int times) {
		// 나머지 연산 := times가 범위보다 크다면 범위안에 넣어야한다 그렇기 위해 나머지 연산을 수행한다.
		times = times % length;// times == 50이라면 50%3 == 2
		// 왼쪽 쉬프트 연산이지만 포인터는 오른쪽으로 이동한다.
		leftIndex = (leftIndex + times) % length; // 범위보다 큰 것을 방지하기 위해 나머지 연산
	}
	
	public void shiftRight(int times) {
		times = times % length;
		// 오른쪽쉬프트 수행은 실제로 포인터를 왼쪽으로 이동하는 것
		leftIndex = (leftIndex - times +length) % length; //  + length을 더하는 것은 times을 뺐을때 음수화가 되는 것을 막기 위해서다
		
	}
	
    // 초기화 매서드
	public void initializePosition() {
		leftIndex = 0; // 처음 0번의 포인터를 가리키고 시작했으므로 현재 포인터가 어디에 있건 0으로 돌아오면 초기화가 된 것이다.
		
	}
}