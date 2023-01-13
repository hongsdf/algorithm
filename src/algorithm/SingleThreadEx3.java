package algorithm;

// 멀티 쓰레드 구현
class MultiThread implements Runnable{
	int num = 0;
	
	@Override
	public void run() {
		for(int i = 0; i <10; i++) {
			if(Thread.currentThread().getName().equals("A")) {
				System.out.println("=========");
				num++;
			}
			System.out.println("ThreadName= "+Thread.currentThread().getName()+"num="+num);
		
			try {
				Thread.sleep(500);
			}catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		
	}

}
public class SingleThreadEx3{
	public static void main(String[] args) {
		MultiThread m = new MultiThread();
		MultiThread m2 = new MultiThread();
		
		Thread thread1 = new Thread(m,"A");
		Thread thread2 = new Thread(m2,"B");
		
		thread1.start();
		thread2.start();
		
		Thread.currentThread().getName();
		
		
	}
}
