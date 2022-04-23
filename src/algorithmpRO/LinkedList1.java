package algorithmpRO;

import java.util.*;
public class LinkedList1 {
	public static void main(String[] args) {
		Solution3 m = new Solution3();
		String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
		m.solution(8, 2, cmd);
	}
}

class Solution3 {
    public String solution(int n, int k, String[] cmd) {
        Node[] nodeArr = new Node[1000000];
        
        for(int i = 0; i < n; i++)
            nodeArr[i] = new Node();
        
        for(int i = 1; i < n; i++) {
            nodeArr[i - 1].next = nodeArr[i];
            nodeArr[i].prev = nodeArr[i - 1];
        }
        
        Deque<Node> stk = new ArrayDeque<>();
       	Node curr = nodeArr[k];
        
        for(String str : cmd) {
        	char c = str.charAt(0);
            switch(c) {
                case 'U' :
                    int x = Integer.parseInt(str.substring(2));
                    for(int i = 0; i < x; i++)
                        curr = curr.prev;
                    break;
                case 'D' :
                    x = Integer.parseInt(str.substring(2));
                    for(int i = 0; i < x; i++)
                        curr = curr.next;
                    break;
                case 'C' :
                    curr.removed = true;
                    stk.push(curr);
                    Node up = curr.prev;
                    Node down = curr.next;
                   	
                    if(up != null)
                        up.next = down;
                    
                    if(down != null) {
                        down.prev = up;
                        curr = down;
                    } else {
                        curr = up;
                    }
                    break;
                case 'Z' :
                   	Node recover = stk.pop();
                   	up = recover.prev;
                    down = recover.next;
                    
                    recover.removed = false;
                    if(up != null) {
                        up.next = recover;
                    }
                    
                    if(down != null) {
                        down.prev = recover;
                    }
                    break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            if(nodeArr[i].removed)
                sb.append("X");
            else
                sb.append("O");
        }
        
        return sb.toString();
    }
    
    class Node {
        boolean removed;
        Node prev;
        Node next;
    }
}