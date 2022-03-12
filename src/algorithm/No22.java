package algorithm;

public class No22 {
	public static void main(String args[]) {
		// 팰린드롬 
		
		boolean flag = false; // 확인
	
		int arr[] = new int[7];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 3;
		arr[5] = 1;
		arr[6] = 0;

		
		
		
		
		int n = arr.length/2;
		System.out.println(n);
		
		for(int i= 0; i <= n ; i++) {
			if(arr[n+i] == arr[n-i]) {
				// arr[2] == arr[2] : 0
				// arr[3] == arr[1] : 1
				// 
				flag = true;
			}else {
				flag = false;
			}
		}
		System.out.println(flag);
		
//		
//		String str = new String();
//		str = "hello world";
//		char[] c = new char[13];
//		for(int i = 0; i< str.length(); i++)
//			c[i] = str.charAt(i);
//		System.out.println(c);
		
	}
}
