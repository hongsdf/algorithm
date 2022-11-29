package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1002 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i <N; i++) {
			String str[] = br.readLine().split(" ");
			// 조규현 정보 기입
			int x1 = Integer.parseInt(str[0]);
			int y1 = Integer.parseInt(str[1]);
			int r1 = Integer.parseInt(str[2]);
			// 백승환 정보 기입
			int x2 = Integer.parseInt(str[3]);
			int y2 = Integer.parseInt(str[4]);
			int r2 = Integer.parseInt(str[5]);
			
			// 두점사이의 거리구하기
			int dist = (int) (Math.pow(x1-x2,2) + Math.pow(y1-y2, 2));
			
			// 두 원의 중심이 같으며, 반지름이 같을때 (무한)
			if(dist == 0 && r1 == r2) {
				System.out.println(-1);
			}
			// 접점이 없을때 (두 원이 떨어져 있다)
			else if(dist > Math.pow(r1 + r2,2)) {
				System.out.println(0);
			}
			// 한 원안에 다른 원이 있으면서 접점이 없을때(포함돤 관계 표현)
			else if(dist < Math.pow(r1-r2,2)) { // 두 점 차이 <  반지름차이가 더 클때 
				System.out.println(0); 
			}
			
			// 내접
			else if(dist == Math.pow(r1-r2, 2)) {
				System.out.println(1);
			}
			
			// 외접(반지름 합이 두점 거리와 같은경우)
			else if(dist == Math.pow(r1 +r2,2)) {
				System.out.println(1);
			}
			else { // 그외 접점 2개
				System.out.println(2);
			}

			// 접점갯수가 무한대 일때
			// 두원의 중심이 같고,반지름이 같을때
			// 접점이 없을때
			// 한원안에 다른 원이 있으면서 접점이 없을때
			// 원의 두 정점차이가 반지름차이보다 작을때

			
			// 접점이 한개인경우 
			// 내접
			// 두 원점중심차이 == 반지름 차이
			
			// 외접
			// 두 중점차이 == 반지름 합
			
			
			// 이외의 조건은 2개
		}
		
		
	}
}
