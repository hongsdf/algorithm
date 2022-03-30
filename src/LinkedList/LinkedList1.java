package LinkedList;

import java.util.*;
class LinkedList1 {
    public ListNode mergeKLists(ListNode[] lists) { // ListNode[] lists ==> [[1,3,4][5,6]] 시각적으로 2차원으로 구성
       int k = lists.length; // 5
       ListNode answer = null; // return 반환할  ListNode
        
        int idx = 0; // lists의 원소를 0 ~ k 까지 하나씩 합치기 위한 idx
        while(idx < k ){ //합치는 과정을 진행할 것이다
           answer = Merge(answer,lists[idx++]); // 합치기 : answer에 이어 붙히기(하나의 노드 씩)
        }
        return answer;
    }
    
    public ListNode Merge(ListNode left,ListNode right){
        if(left == null ) return right; // left가 비어 있으면 right으로 반환
        if(right == null) return left; // right가 비어 있으면 left로 반환
        
       ListNode temp = null; // 임시 ListNode
       // 처음 ListNode세팅 left,right
       if(left.val >= right.val){ 
           temp = right; // 작은 값을 넣는다
           right = right.next;
           
       }else{
           temp = left;
           left = left.next;
       }
        // 들어온 left와 right중 하나를 선택해서 node에 연결
        ListNode node = temp;
        // 시각적 temp -> node(left) -> right|| left
        
        // 연결 작업
        while(left != null && right != null ){
            if(left.val >= right.val){
                node.next = right;
                right = right.next;
            }else{
                node.next = left;
                left = left.next;
            }
            // if,else 둘중 하나를 넣고 node진행했으면 
            // 다음 node 자리를 진행 시킴
            node = node.next;
            
        }
        // left,right 중 남은 값이 있으면 node의 자리를 채워넣음
        if(left != null) node.next = left;
        if(right != null) node.next = right;
        
        
        
        return temp;
        
        
    }
       
        
        
    
}