package Strings;

public class test1 {
	public static void main(String[] args) {
		String str = "Hello warold";
//		int index = str.indexOf("H");
		int index = str.indexOf("o", 5); 
		int lastIndex = str.lastIndexOf("wa",11);
		System.out.println(lastIndex);
	
		System.out.println(index);
	}
}
