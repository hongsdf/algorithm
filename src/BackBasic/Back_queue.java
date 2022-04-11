package BackBasic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Queue : 문제를 순서대로 처리해야 할때 주로 사용된다.
// 추가 할때는 end이동 오른쪽으로
// 삭제 할ㄸ때는 start이동 오른쪽으로
// q는 끝에서 들어와 왼쪽으로 이동하는 구조이다, 그러므로 구현시 반대로 구현해야 한다.

// 실제 디버깅을 해보면 배열의 크기를 줄이거나 안의 원소를 변경하지 않는다.
public class Back_queue {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int q[] = new int[T];
		int start = 0;
		int end = 0;
		while(T -->0) {
			String Line[] = br.readLine().split(" ");
			String command = Line[0];
			if(command.equals("push")) { // end 포인터가 움직인다.
				q[end++] = Integer.parseInt(Line[1] ); 
			}else if(command.equals("pop")) { // pop을 할때는 start포인터
				if(start == end) { // start와 end가 같으면 뺄것이 없다.
					bw.write("-1\n");
				}else {
					bw.write(q[start]+"\n");
					start++;
				}	
			}else if(command.equals("size")) {
				// ab : end는 추가 하여서 2, start는 0라고 하면
				// 2  - 0
				bw.write(end-start+"\n");
				
			}else if(command.equals("empty")) {
				if(start == end) {
					bw.write("1\n");
				}else {
					bw.write("0\n");
				}
				 
			}else if(command.equals("front")) {
				// 출력만 하고 제거 하지는 않는다.
				// 그리고 start포인터는 움직이지 않는다. 뺀게 없으니깐
				 if(start == end) { //들어 잇는 것이 없다
					 bw.write("-1\n");
				 }else { // 출력만 하면된다. start이동 x
					 bw.write(q[start]+"\n");
				 }
			}else if(command.equals("back")) {
				if(start == end) {
					bw.write("-1\n");
				}else { //출력만 하면 됨
					bw.write(q[end-1]+"\n"); 
					// end < 0 보다 작아진다면 start는 아예 움직이지도 않았으로 시행 조차 되지 않았을 것이다
					// 보통 end > start보다 크다
				}
			}
		}
		bw.flush();
	}
}
