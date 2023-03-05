package Monster;
import java.lang.*;
import java.util.*;
import java.io.*;




public class 문제5I두선분 {
	public static void main(String args[]) throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 수직이 
		int T = Integer.parseInt(br.readLine());
		while(T --> 0){
			String input[] = br.readLine().split(" ");
			int Ax = Integer.parseInt(input[0]);
			int Ay = Integer.parseInt(input[1]);
			
			int Bx = Integer.parseInt(input[2]);
			int By = Integer.parseInt(input[3]);
			
			int Cx = Integer.parseInt(input[4]);
			int Cy = Integer.parseInt(input[5]);
			
			int Dx = Integer.parseInt(input[6]);
			int Dy = Integer.parseInt(input[7]);
			
			List<Integer> list = new ArrayList<>(Arrays.asList(Ax,Ay,Bx,By,Cx,Cy,Dx,Dy));
			// long line = (long)Math.pow(Ax-Cx,2) + (long)Math.pow(Ay-Cy,2); // x증가량
			// long line2 = (long)Math.pow(Bx-Dx,2) + (long)Math.pow(By-Dy,2); // y증가량
			
			long Xincreasing = (long)Math.pow(Ax-Bx,2);
			if(Xincreasing == 0) Xincreasing = 1;
			long Yincreasing = (long)Math.pow(Ay-By,2);
			long line = Yincreasing/Xincreasing;
			
			long Xincreasing2 = (long)Math.pow(Cx-Dx,2);
			if(Xincreasing2 == 0) Xincreasing2 = 1;
			long Yincreasing2 = (long)Math.pow(Cy-Dy,2);
			long line2 = Yincreasing2/Xincreasing2;
			
			// 두점 사이의 거리
			// long distX = (long)Math.pow(Ax-Cx,2) + (long)Math.pow(Ay-Cy,2);
			// long distY = (long)Math.pow(Bx-Dx,2) + (long)Math.pow(By-Dy,2);
			
			// 기울기가 같고 && 두점사이의 거리가 0 이면  -> yes
			if(line == line2 && sameDist(list)){
				bw.write("YES\n") ;
			}else if(line == line2){ // 기울기가 같고 && 두점사이의 거리가 1이상이면 -> no
				bw.write("NO\n");
			}else{
				bw.write("YES\n");
			}
			
		
			
			
		}
		
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	// 두점사이의 거리가 0이면 true, 1이상이면 false
	public static boolean sameDist(List<Integer> list){
		// x좌표가 같음
		if(list.get(0) == list.get(4) && list.get(1) == list.get(5)) return true;
		// y좌표가 같음
		if(list.get(2) == list.get(6) && list.get(3) == list.get(7)) return true;	
		
		return false;
	}
}
