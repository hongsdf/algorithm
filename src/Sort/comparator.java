package Sort;

import java.util.*;

//Write your Checker class here
class Checker implements Comparator<Player>{

	@Override
	public int compare(Player o1, Player o2) {
		int n =0;
		if(o1.score > o2.score) {
			return -1; // 반환값이 음수이면 내림차순 
		}else if(o1.score == o2.score) { // 점수가 같으면 다음 조건 확인 
			return o1.name.compareTo(o2.name); // 점수가 같으면 문자(이름의 길이로 정렬한다) //오름차순
			
			
		}else {
			return 1; // 반환값이 양수이면 오름 차순
		}
		
		
		
		
//		if(o1.name.charAt(0) > o2.name.charAt(0)) return 1; // compare()함수에서 반환값이 양수이면 오름차순
//		else if(o1.name == o2.name) return (o1.name).compareTo(o2.name);
//		else return -1; //  compare( )함수에서 반환값이 음수이면 내림차순
	}

}

class Player{
	String name;
	int score;
 
 Player(String name, int score){
     this.name = name;
     this.score = score;
 	}
 
}

public class comparator{
	public static void main(String[] args) {
     Scanner scan = new Scanner(System.in);
     int n = scan.nextInt();

     Player[] player = new Player[n];
     Checker checker = new Checker(); //정렬 기준
     
     for(int i = 0; i < n; i++){
         player[i] = new Player(scan.next(), scan.nextInt()); // ( 이름  , 나이)
     }
     scan.close();
  
     Arrays.sort(player, checker); // player 배열을 checker기준으로 정렬한다
     for(int i = 0; i < player.length; i++){
         System.out.printf("%s %s\n", player[i].name, player[i].score);
     	
     	}
	}
}