package Thisisjava;

import TestALroigthm.SmartPhone;

public class SmartPhoneExample {
	public static void main(String[] args) {
		SmartPhone sm = new SmartPhone("갤럭시", "금색");
		
		System.out.println(sm.model);
		System.out.println(sm.color);
		
		sm.setWifi(true);
		System.out.println(sm.wifi);
		
		sm.bell();
		sm.internet();
		sm.SendVoice("메서지를 입력합니다");
		sm.receiveVoice("연락합니다");
		sm.hangUp();
	}
}
