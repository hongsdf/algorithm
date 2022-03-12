package datastructure;

public class BufferedReader_trim {
	public static void main(String[] args) {
		String str = " Hello world! ";
		System.out.println(str);
		
		String str2 = str.trim(); // trim() : String에서 왼쪽,오른쪽 공백을 제거 해준다
		System.out.println(str2);
	}
}
