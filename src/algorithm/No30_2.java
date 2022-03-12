package algorithm;

public class No30_2 {
	
	static void color(int x, int y) {
		if(map[x][y] != 1 ) map[x][y] = color;
		
		if(x+1 < size  && map[x+1][y] != 1 && map[x+1][y] != color )
			color(x+1,y);
		if(x-1 >= 0 && map[x-1][y] != 1 && map[x-1][y] != color )
			color(x-1,y);
		if(y-1 >= 0 && map[x][y-1] != 1 && map[x][y-1] != color )
			color(x,y-1);
		if(y+1 < size && map[x][y+1] != 1 && map[x][y+1] != color )
			color(x,y+1);
		
	}
	
	
	static int size = 5;
	static int color = 2;
	
	static int [][]map= {{1,0,0,0,0},
						 {0,0,1,1,0},
						 {0,1,0,0,1},
						 {0,0,0,0,0},
						 {0,1,0,0,0}};
	
	public static void main(String[] args) {
		for(int i = 0; i< size; i++) {
			for(int j = 0; j <size; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
			
			
		}
		color(1,1);
		System.out.println(" ");
		for(int i = 0; i< size; i++) {
			for(int j = 0; j <size; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
			
			
		}
		
	}
}
