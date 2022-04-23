package algorithmpRO;

import java.util.*;

public class Editor {
	public static void main(String[] args) {
		Solution2 m = new Solution2();
		String[] cmd = { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z" };
		m.solution(8, 2, cmd);
	}
}
class Solution2 {
    /* 연결리스트를 사용할것이다. 
        삽입,삭제등 이 있으므로 시간 제한을 줄이기 위해 연결리스틀 사용하자
    
    
    */
    class Node{
        boolean check; // 현재노드가 삭제 되었는지 확인 여부
        Node pre; // 이전 노드
        Node next; // 다음 노드
    }
    
    public String solution(int n, int k, String[] cmd) {
        Node[] nodeArr = new Node[1000000];
        
        Stack<Node> st = new Stack<>();
        // Node[] nodeArr = new Node[n];
        
        for(int i = 0; i <n; i++){
            nodeArr[i] = new Node(); // 문제 수 n만큼 노드 생성(하나씩 주입)
        }
        
        //연결작업
        for(int i =1; i<n; i++){
            // 항상 양방향으로 연결
            nodeArr[i-1].next = nodeArr[i];
            nodeArr[i].pre = nodeArr[i-1];
        }
        
        Node curr = nodeArr[k]; /* k 번째 [] 인덱스에 있는 것이 시작 노드(커서) 이다*/
        for(String command : cmd){
           char c = command.charAt(0);
            
           switch(c){
               case 'U': // X 칸 커서를 위로 이동
                int x = Integer.parseInt( command.substring(2) );
                while(x --> 0){
                    curr = curr.pre; // 현재커서를 이동할것 U : 이전으로
                }
                 break;
               case 'D': // X 칸 커서를 아래로 이동
                x = Integer.parseInt( command.substring(2) );
                while(x --> 0){
                    // 현재의 다음이 현재가 된다
                    curr = curr.next; // 현재커서를 아래로 이동
                    
                }
                    break;
                 case 'C': // 커서있는 칸을 삭제
                    curr.check = true; //삭제 표기
                    st.push(curr);
                   
                   // 현재 커서와 관련된 이전,이후 노드 저장
                   Node up = curr.pre;
                   Node down = curr.next;
                   
                   //up과 down을 연결 시키자
                   if(up != null) up.next = down;
                   if(down != null) { 
                     down.pre = up;
                   } // 단, 삭제된 행이 가장 마지막 행인 경우 바로 윗 행
                   /*마지막 행이 삭제 되면 curr없어지고, down은 null up <-> curr <-> null(down)*/
                   else{
                       curr = up;
                   }
                
                break;
               case 'Z':
                   Node re = st.pop(); //st에서 pop해서
                   re.check = false; // 다시 복원 표기
                   
                   // 그때 위치로 돌아감
                  // re:상수값이고
                  // up,down은 null일 수도 있다.
                   
                  up = re.pre;
                  down = re.next;
                   
                  if(up != null) up.next = re;
                  if(down != null) down.pre = re;
                   
                   
                   
                 break;  
                   
           } 
        }
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<n; i++){
            if(nodeArr[i].check){
                sb.append('X');
            }else{
                sb.append('O');
            }
        }
        
        
        
        return sb.toString();
    }
}