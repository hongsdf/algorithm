package algorithm;

// 멀티 쓰레드 구현
class ATM implements Runnable{
	private long depository = 10000;

	@Override
	public void run() {
		synchronized (this) {
			for(int i = 0; i <10; i++) {
				notify(); // 하나의 쓰레드만 모니터에 출력 할수 있게 하는 기능 : (ATM 인출시 A,B가 있다면 한명만 접근이 가능하다) 즉 하나의 쓰레드만 접근이 가능하다.
				try {
					wait();
					Thread.sleep(1000);
				}catch(InterruptedException ex) {
					ex.printStackTrace();
				}
				if(getDepositeMoney() <= 0) {
					break;
				}
				withDraw(1000);
			}
			
		}
		
	}

	private void withDraw(long money) {
		if(getDepositeMoney() > 0 ) {
			depository -= money;
			System.out.println(Thread.currentThread().getName()+",");
			System.out.printf("잔액 : %,d 원 %n", getDepositeMoney());
		}else {
			System.out.println(Thread.currentThread().getName()+",");
			System.out.println("잔액이 부족합니다.");
		}
		
		
		
		
	}

	private long getDepositeMoney() {
		
		return depository;
	}
	
	
	

}
public class SingleThreadEx4{
	public static void main(String[] args) {
		ATM atm = new ATM();
		// Multi thread을 구현하기 위해 쓰레드 생성
		Thread t1 = new Thread(atm,"A"); // (사용할 클래스명, 쓰레드 이름)
		Thread t2 = new Thread(atm,"B");
		t1.start(); // 쓰레드 실행  start() 매서드
		t2.start(); // 쓰레드 실행  start() 매서드
		
		
	}
}
