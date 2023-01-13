package algorithm;


public class SingleThreadEx2 extends Thread{
	private int[] temp;
	
	SingleThreadEx2(String threadName){
		super(threadName);
		temp = new int[10];
		
		for(int i = 0; i <temp.length; i++) {
			temp[i] = i;
		}
	}
	
	public void run() {
		for(int n : temp) {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException ex) {
				ex.printStackTrace();
			}
			System.out.println("스레드 이름:"+currentThread().getName());
			System.out.println("temp"+ n);
		}
	}
	
	public static void main(String[] args) {
		SingleThreadEx2 m = new SingleThreadEx2("메시");
		m.run();
		
	
	}
}
