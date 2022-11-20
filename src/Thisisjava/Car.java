package Thisisjava;

public class Car {
	
		// 비공개 필드 선언
		private int speed;
		private boolean stop;
		
		
		public int getSpeed() {
			return speed;
		}
		public void setSpeed(int speed) {
			if(speed < 0) {
				speed = 0;
				this.speed = speed;
			}else {
				this.speed = speed;
			}
		}
		public boolean isStop() {
			return stop;
		}
		public void setStop(boolean stop) {
			this.stop = stop;
			if(stop) {
				this.speed = 0;
			}
		}
	
}
