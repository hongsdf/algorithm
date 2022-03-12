package Strings;

import java.util.StringTokenizer;

public class token2 {

	public static void main(String[] ar){
		String str="this-=string-includes=delims";
		StringTokenizer stk=new StringTokenizer(str,"-=",true);
		System.out.println(str);
		System.out.println();
			
		System.out.println("total tokens:"+stk.countTokens());
		System.out.println("================tokens==================");
		while(stk.hasMoreTokens()){
			System.out.println(stk.nextToken());
		}
		System.out.println("total tokens:"+stk.countTokens());
	}


}
