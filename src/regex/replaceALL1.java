package regex;

public class replaceALL1 {

	public static void main(String[] args) {
		String replaceTest = "우리의 리플레이스  리플레이스테스트";
		System.out.println(replaceTest.replace("리플레이스", "replace")); // 우리의 replace 테스트 }
	}

}
//  replaceAll()  :정규식 표현이 가능 매개변수타입(String )
// replace() : (Charsequence )
// String replace(CharSequence target, CharSequence replacement)

//- replace() 함수는 대상 문자열을 원하는 문자값으로 변환하는 함수이다.
//
//- 첫번째 매개변수는 변환하고자 하는 대상이 될 문자열
//
//- 두번째 매개변수는 변환할 문자 값



