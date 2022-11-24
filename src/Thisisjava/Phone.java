package Thisisjava;

public class Phone {
	public String model;
	public String color;
	
	public Phone(String model, String color){
		this.model = model;
		this.color = color;
		System.out.println("Phone(String model, String color) 생성자 완료");
	}
//	public Phone(){
//		System.out.println("Phone 생성자 완료");
//	};
	
	// 메서드 선언
	public void bell() {
		System.out.println("벨이 울립니다.");
	}
	
	public void SendVoice(String message) {
		System.out.println("자기 : "+ message);
	}
	public void receiveVoice(String message) {
		System.out.println("상대방 >" + message);
	}
	public void hangUp() {
		System.out.println("전화를 끊다");
	}
}
