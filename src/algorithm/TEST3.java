package algorithm;

class Card1{
	static int cnt;
	int data;
	Card1(int data){
		this.data = data;
		cnt++;
	}
}

public class TEST3 {
	 public static void main(String[] args) {
		Card1 c1 = new Card1(6);
		Card1 c2 = new Card1(3);
		Card1 c3 = new Card1(2);
		Card1 c4 = new Card1(1);
		System.out.println(Card1.cnt);
	 }	
}
