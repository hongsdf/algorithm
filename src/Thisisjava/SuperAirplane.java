package Thisisjava;

public class SuperAirplane extends Airplane{
	// 상수 선언
	public static final int NORMAL = 1;
	public static final int SUPERSONIC = 2;
	
	// 상태 필드 선언
	public int flymode = SUPERSONIC;
	
	@Override
	public void fly(int flymode) {
		if(flymode == SUPERSONIC ) {
			System.out.println("초음속 모드");
		}else {
			super.fly();
			
		}
	}
}
