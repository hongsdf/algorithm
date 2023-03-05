package Monster;
import java.io.*;
import java.lang.*;
import java.util.*;



public class 문제5H두직사각형 {
	public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			int T = Integer.parseInt(br.readLine());
			while(T --> 0){
				String input[] = br.readLine().split(" ");
				int Ax = Integer.parseInt(input[0]); // a
				int Ay = Integer.parseInt(input[1]); // b
				
				int Bx = Integer.parseInt(input[2]); // c
				int By = Integer.parseInt(input[3]); // d
				
				int Px = Integer.parseInt(input[4]);
				int Py = Integer.parseInt(input[5]);
				
				int Qx = Integer.parseInt(input[6]);
				int Qy = Integer.parseInt(input[7]);
				
				
				// 1번 사각형
				List<Integer> rect1 = new ArrayList<>(Arrays.asList(Ax,Ay,Ax,By,Bx,By,Bx,Ay));
				
				
				// 2번 사각형
				List<Integer> rect2 = new ArrayList<>(Arrays.asList(Qx,Py,Qx,Qy,Px,Qy,Px,Py));
//				List<Integer> rect2 = new ArrayList<>(Arrays.asList(Qx,Py,Qx,Qy,Px,Qy,Px,Py));
				
				
				// 세로 포함 여부
				// 가로 포함 여부
				int answer = 0;
				// 가로 포함 && 세로 포함 => 큰 사각형이 작은 사각형을 포함
				if(width(rect1,rect2) && height(rect1,rect2)){
					answer = Math.min(area(rect1),area(rect2));
				}else {
					answer = Math.abs(rect1.get(3) - rect2.get(7)) * Math.abs(rect1.get(4) - rect2.get(0));
//				// 가로 포함 => 위,아래 체크
//				else if(width() && !height()){
//					answer = Math.abs(rect2.get(0) - rect1.get(6))  * Math.abs( rect2.get(3) - rect1.get(3));
//				}
//				// 세로 포함 => 왼쪽,오른쪽 체크
//				else if(!width() && height()){
//				for(int i = 0; i < 8; i+=2){
//					max = Math.max(rect1.get(i),rect2.get(i)) ;
//				}
//				answer = Math.abs(rect1.get(1) - rect1.get(3)) * Math.abs( rect2.get(6) - rect1.get(6) );
				}
				// 아니면 0
				
				
				System.out.println(answer);
			}
		}
	public static boolean height(List<Integer> rect1, List<Integer> rect2){
		// 1 1 1 3 3 3 3 1
		
		// 2 2 2 4 4 4 4 2 
		
		int a =rect1.get(0);
		int b = rect1.get(6);
		int c = rect2.get(0); 
		int d = rect2.get(6);
		if(a <= c && b >= d){
			return true;
		}
		return false;
			
	}
	
	public static boolean width(List<Integer> rect1, List<Integer> rect2){
		// 1 1 1 3 3 3 3 1
		// 2 2 2 4 4 4 4 2 
		int a = rect1.get(1);
		int b = rect1.get(3);
		int c = rect2.get(1); 
		int d = rect2.get(3);
		if(a <= c && b >= d){
			return true;
		}
		return false;
	}
	
	public static int area(List<Integer> list){
			// 1 1 1 3 3 3 3 1
		return Math.abs(list.get(1) - list.get(3)) * Math.abs(list.get(0) - list.get(6));
	}
}