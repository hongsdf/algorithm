package backjun;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Back2869 {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine(), " "); // " " 규칙에 맞춰 아스키코드 받아옴
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int day = (C - B) / (A - B);
		 
		// 나머지가 있을 경우 (잔여 블럭이 있을 경우)
		if( (C - B) % (A - B) != 0 ) {
			day++;
		}
		System.out.println(day);	
		}
	
	}

//	 static int climb(int a, int b, int c) {
//		int day = 1;
//		while(true) {
//			if(a < c) {  // 2 < 5  	 2 < 4   2 < 3    2 < 2         5 < 6    5 < 2
//				c = c-a; // c = 3    c = 2   c = 1    c = 0         c = 1  
//				c +=b;   // c = 4    c = 3   c = 2    c = 1         c = 2
//				day++; 
//			}else {
//				break;
//			}	
//				
//		}
//		 
//		 
//		 return day;
//	}
	
	// 2 1 5  4  5-2 = 3 * 1 = 3
	//  0 0 0 0 0
	// 5 -2 =3+1 =4 -> 4-2 =2 +1 3
	//  0 0 0 0 0
	// 5 1 6    2  = 6-5 = 1 * 1 +
	// 0 0 0 0 0 0
	// 100 99 1000000000  = 999999901
//	0 (0 x) 0 (0 x) 0 (0 x) 0
	

