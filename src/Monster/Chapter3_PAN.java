package Monster;

import java.io.*;
import java.lang.*;
import java.util.*;


public class Chapter3_PAN {
	public static final Scanner scanner = new Scanner(System.in);

	public static int getUniqueRangeNumber(int[] birthDate, int n, int k)
	{
		int answer = 0;
		// 밑에서 생성한 클래스를 가져온다(= 테이블)
		FrequencyTable ft = new FrequencyTable();
		// ft 테이블에의 필드
		// uniqueElements 값
		// 빈도수 배열
		
		// 슬라이딩 윈도우 초기화 필요 
		for(int i = 0; i < k; i++) {
			//입력 받은 생일 정보를 삽입
			ft.addBirthDate(birthDate[i]); // 생일을 입력받아 빈도수 배열을 갱신
		}
		// [1,1,1,1,1] 원소 중 k == 5이면 모두 유일한 원소가 된다.
		if(ft.uniqueElements == k) {
			answer +=1;
		}
		//슬라이딩 윈도우 
		for(int i = 1; i+k-1 <n; i++) {
			ft.removeBirthDate(birthDate[i-1]); // 왼쪽 값 제거
			ft.addBirthDate(birthDate[i+k-1]); // 오른쪽 값 추가
			// addBirthDate, addBirthDate는 uniqueElements와 빈도수 배열을 갱신해주는 내장기능이 있다.(밑에서 생성)
			if(ft.uniqueElements == k) {
				answer +=1;
			}
		}
		

		return answer;
	}

	public static void main(String[] args) throws Exception {
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[] birthDate = new int[n];
		for(int i = 0 ; i < n ; i ++)
		{
			birthDate[i] = scanner.nextInt();
		}

		int answer = getUniqueRangeNumber(birthDate, n, k);

		System.out.println(answer);
	}

}
// 윈도우 슬라이딩 기법 := 
// 왼쪽값을 빼고 오른쪽 값을 추가하여 k 배열의 원소를 확인한다.
// k원소중 중복값이 없다는 것은 유일한 값 == 빈도수가 1이다라는 뜻이다.
// 그러면 슬라이딩 윈도우기법을 사용했을때
// 왼쪽값을 빼고 오른쪽 값을 넣었을때의 시점을 잘 관찰한다.

// 중복 문제에서 빈도수를 생각해 볼 수 있다.(빈도수가 1이라는 것은 유일한 값 := 중복되지 않은 값을 의미한다.)

class FrequencyTable // 따로 클래스를 만들어 관리 한다.
{
	
	public static final int MAX_SIZE = 1000000; // 배열의 최대 크기

	int uniqueElements; //현재 중복이 존재하지 않는 unique한 생일의 수
	int[] frequency;    //frequency[b] := 생일이 b인 정보의 수

	FrequencyTable(){
		this.uniqueElements = 0;
		this.frequency = new int[MAX_SIZE];
	}

	/**
	 * 새로운 생일을 등록하고 빈도수를 갱신한다.
	 * @param birthDate
	 */
	
	void addBirthDate(int birthDate) // 생일이 추가된경우 := 오른쪽 값을 넣은 경우 , 매서드 역할 = 유일한 갯수 갱신과 빈도수 배열
	{
	  // uniqueElements 갯수와 빈도수 배열을 독립적으로 관리한다.
      // uniqueElements
		int cnt = frequency[birthDate]; // 추가한 생일의 빈도수를 확인한다.
		if(cnt == 0) { // 기존에 0이었던 생일이 추가 되어 1이되면 유일한 값이 된다.
			this.uniqueElements += 1; // this. := class FrequencyTable의 유일한 갯수 증가
		}else if(cnt == 1) { //기존에 1이었던 생일이 추가되어 2가 되어 유일한 값이 아니게 된다.
			this.uniqueElements -=1;
		}
		
	
		
	  // 빈도수 배열
		// 해당 생일이 들어오면 빈도수 증가
		this.frequency[birthDate]++;// this. := class FrequencyTable의 빈도수 배열을 나타냄
		
		
		
		
	}

	/**
	 * 기존의 생일을 제거하고 빈도수를 갱신한다.
	 * @param birthDate
	 */
	// 왼쪽 값을 빼는 경우
	void removeBirthDate(int birthDate) // 메서드의 기능 := 빈도수 갱신과 유일한 갯수 갱신
	{
		// uniqueElements과 빈도수 배열을 독립적으로 관리한다.
		// uniqueElements
		int cnt = frequency[birthDate]; // 현재 삭제되는 생일의 빈도수 체크
		if(cnt == 2) { //기존에 2였던 값이 삭제되어 1이되면 유일한 값이 된다.
			this.uniqueElements +=1;
			
		}else if(cnt == 1) { // 기존에 유일한 값이 었는데 생일를 제거하게 되어 유일한 값이 아니게 된다.
			this.uniqueElements -=1;
		}
		
		
		// 빈도수 배열
		this.frequency[birthDate]--;
		
		
	}

}
