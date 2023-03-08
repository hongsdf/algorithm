package OS;

public class 뮤택스락 {
	static boolean lock = false;
	static int sum = 10;
	public static void main(String[] args) {
		
		acquire();
		release();
		
	}
	// 임계구역 진입 전
	public static void acquire() {
		while(lock == true) {
			System.out.println("대기중");
		}
		sum--;
		lock = true;
	}
	
	// 작업 사용 후  임계구역 상태 변환
	public static void release() {
		lock = false;
	}
}
