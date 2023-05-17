package solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


class Pointer{
	
	int x;
	int y;
	
	Pointer(char x , int y){
		
		if(x == 'A') { // 65->7, 66->8,
			this.x = 7;
		}else if(x == 'B') {
			this.x = 6;
		}else if(x == 'C') {
			this.x = 5;
		}else if(x == 'D') {
			this.x = 4;
		}else if(x == 'E') {
			this.x = 3;
		}else if(x == 'F') {
			this.x = 2;
		}else if(x == 'G') {
			this.x = 1;
		}else if(x == 'H') {
			this.x = 0;
		}
		this.y = y;
	}
}

public class 킹 {
	
	static int Kingx = 0;
	static int Kingy = 0;
	static int Stonex = 0;
	static int Stoney = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input[] = br.readLine().split(" ");
		 
		String king = input[0]; //A1 -> 7,0, B2 -> 6,1
		// 좌표 
		Pointer KingPoint = new Pointer(king.charAt(0),king.charAt(1)-48);
		Kingx = KingPoint.x;
		Kingy = KingPoint.y;
		
		
		
		String stone = input[1];
		Pointer StonePoint = new Pointer(stone.charAt(0),stone.charAt(1)-48);
		Stonex = StonePoint.x;
		Stoney = StonePoint.y;
		
		
		
		int T = Integer.parseInt(input[2]);
		
		while(T --> 0) {
			String choice = br.readLine();
			solve(choice);
		}
		char resultX = 0;
		if(Kingx == 1) { // 65->7, 66->8,
			resultX = 'A';
		}else if(Kingx == 2) {
			resultX = 'B';
		}else if(Kingx == 3) {
			resultX = 'C';
		}else if(Kingx == 4) {
			resultX = 'D';
		}else if(Kingx == 5) {
			resultX = 'E';
		}else if(Kingx == 6) {
			resultX = 'F';
		}else if(Kingx == 7) {
			resultX = 'G';
		}else if(Kingx == 8) {
			resultX = 'H';
		}
		
		
		char resultSX = 0;
		if(Stonex == 1) { // 65->7, 66->8,
			resultSX = 'A';
		}else if(Stonex == 2) {
			resultSX = 'B';
		}else if(Stonex == 3) {
			resultSX = 'C';
		}else if(Stonex == 4) {
			resultSX = 'D';
		}else if(Stonex == 5) {
			resultSX = 'E';
		}else if(Stonex == 6) {
			resultSX = 'F';
		}else if(Stonex == 7) {
			resultSX = 'G';
		}else if(Stonex == 8) {
			resultSX = 'H';
		}
		
		
		
		
		String answerk = resultX+ String.valueOf(Kingy);
		String answers = resultSX+ String.valueOf(Stoney);
		
		bw.write(answerk+"\n");
		bw.write(answers+"\n");
		
		  
		bw.flush();
		bw.close();
		br.close();
		 
	}

	private static void solve(String choice) {
		/*
		 *  R : 한 칸 오른쪽으로
			L : 한 칸 왼쪽으로
			B : 한 칸 아래로
			T : 한 칸 위로
			RT : 오른쪽 위 대각선으로
			LT : 왼쪽 위 대각선으로
			RB : 오른쪽 아래 대각선으로
			LB : 왼쪽 아래 대각선으로
		 */
		
		
		if(choice.equals("R")) {
			// 범위를 초과하면 RETURN
			if(Kingy+1 > 7 && Kingy+1 == Stoney) {
				return;
			}
			Kingy = Kingy+1;
			
		}else if(choice.equals("L")) {
			if(Kingy-1 < 0 && Kingy+1 == Stoney) {
				return;
			}
			Kingy = Kingy-1;
			
		}else if(choice.equals("B")) {
			if(Kingx+1 > 8 && Kingx+1 == Stonex) {
				return;
			}
			Kingx = Kingx+1;
			
		}else if(choice.equals("T")) {
			if(Kingx-1 < 0 && Kingx-1 == Stonex) {
				return;
			}
			Kingx = Kingx-1;
		}else if(choice.equals("RT")) {
			if((Kingy+1 > 8 || Kingx-1 < 0 ) ||  Kingx-1 == Stonex && Kingy-1 == Stoney) {
				return;
			}
			Kingx = Kingx-1;
			Kingy = Kingy+1;
			
			
		}else if(choice.equals("LT")) {
			if((Kingy-1 < 0 || Kingx-1 < 0 ) ||  Kingx-1 == Stonex && Kingy-1 == Stoney) {
				return;
			}
			Kingx = Kingx-1;
			Kingy = Kingy-1;
			
		}else if(choice.equals("RB")) {
			if((Kingy+1 > 8 || Kingx+1 > 8 ) || Kingx-1 == Stonex && Kingy-1 == Stoney) {
				return;
			}
			Kingx = Kingx+1;
			Kingy = Kingy+1;
			
		}else if(choice.equals("LB")) {
			if((Kingy-1 < 0 || Kingx+1 > 8) ||  Kingx-1 == Stonex && Kingy-1 == Stoney) {
				return;
			}
			Kingx = Kingx+1;
			Kingy = Kingy-1;
			
		}
		
	}
}
