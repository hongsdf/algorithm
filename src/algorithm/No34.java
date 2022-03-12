package algorithm;

public class No34 {

	static int size = 5;
	
	static int house[] = new int [5]; // 세대원을 출력하는 배열 { * , * ,* 
	
	
	static int arr[][] = {{ 1, 0, 0, 1, 1 },
						  { 0, 0, 0, 0, 1 },
						  { 1, 0, 1, 0, 0 },
						  { 1, 1, 0, 0, 1 },
						  { 1, 1, 0, 0, 1 }};

	// 세대수 3개
	// 3, 5, 2

	static void apartment(int x, int y, int apartnum ) { // apartnum : 단지 번호
			arr[x][y] = 0; // * 1을 0으로 뒤집어 중복을 방지 한다
			house[apartnum]++; // house[] : 번호에 맞는 세대원 증가
		
			if(x+1 < size && arr[x+1][y] == 1 ) {
				apartment(x+1, y, apartnum);
			}
			if(x-1 >= 0 && arr[x-1][y] == 1) {
				apartment(x-1,y,apartnum);
			}
			if(y-1 >= 0 && arr[x][y-1] == 1) {
				apartment(x,y-1,apartnum);
			}
			if(y+1 <size && arr[x][y+1] == 1) {
				apartment(x,y+1,apartnum);
			}
			
			
			
		
		
		
		
			
	
	}

	public static void main(String[] args) {
		int apartnum = 0;
		for(int i = 0; i <size; i++) {
			for(int j=0; j<size; j++) {
				if(arr[i][j] == 1 ) { // 2차배열을 순회하다 1을 발견하면 메서드(x,y,단지명) 실행
					apartment(i,j,apartnum); //apartnum : 단지 번호
					apartnum++;
					
				}
			}
			
		}
		System.out.println(apartnum);
	
		for(int i : house) {
			System.out.print(i + " ");
		}
		
		
	}
}
