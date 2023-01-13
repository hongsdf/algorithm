package algorithm;


public class SingleThreadEx implements Runnable{
	private int[] temp;
	
	SingleThreadEx(String threadName){
		
		temp = new int[10];
		
		for(int i = 0; i <temp.length; i++) {
			temp[i] = i;
		}
	}
	
	
	
	public static void main(String[] args) {
		SingleThreadEx m = new SingleThreadEx("메시");
		m.run();
		
	
	}



	@Override
	public void run() {
		for(int n : temp) {
			try {
				Thread.sleep(100);
			}catch(InterruptedException ex) {
				ex.printStackTrace();
			}
			System.out.println("쓰레드 이름 "+Thread.currentThread().getName());
			System.out.println(n);
		}
		
	}
}
