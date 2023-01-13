package algorithm;

import java.io.IOException;
import java.lang.management.ManagementFactory;

public class Pidtest {
	public static void main(String[] args) throws IOException {
		System.out.println("hello world");
		System.out.println(ManagementFactory.getRuntimeMXBean().getName());
		
		// 프로세스 실행 및 PID 확인
		ProcessBuilder builder = new ProcessBuilder("cmd.exe");
		Process process = builder.start();
		System.out.println(process);
	}
	
}



