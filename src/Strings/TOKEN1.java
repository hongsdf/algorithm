package Strings;

public class TOKEN1 {

	public static void main(String[] ar){
		String str="Hello world!";
		System.out.println(str);
		System.out.println();
			
		System.out.println("==========using split method============");
		String []tokens=str.split(" ");
			
		for(int i=0;i<tokens.length;i++){
			System.out.println(tokens[i]);
		}
	}

}
