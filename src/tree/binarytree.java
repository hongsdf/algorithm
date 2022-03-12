package tree;
// 구조체 : 구조체란 클래스랑 비슷한 형식이나 생성자와 필드만 정의 되어있는 것
class treenode{
	int data;
	treenode leftchild;
	treenode rightchild;
	
	public treenode(int data) {
		this.data = data;
	}
}


public class binarytree {
	public static int num = 15;
	
	// 전위 순회
	// 자기 자신 노드를 출려하고
	// 왼쪽 자식 확인
	// 오른쪽 자식 확인
	public static void preorder(treenode n) {
		if(n != null) {
			System.out.print(n.data+" ");
			preorder(n.leftchild);
			preorder(n.rightchild);
		}
	}
	// 중위 순회
	// 왼쪽 자식 확인
	// 자기 자신 출력
	// 오른쪽 자식 확인
	public static void midorder(treenode n) {
		if(n != null) {
			midorder(n.leftchild);
			System.out.print(n.data+" ");
			midorder(n.rightchild);
		}
	}
	
	// 후위 순회(가장 많이 사용되는 형식)
	// 왼쪽 노드를 순회
	// 오르쪽 노드를 순회
	// 자기 자신 출력
	public static void postorder(treenode n) {
		if(n != null) {
			postorder(n.leftchild);
			postorder(n.rightchild);
			System.out.print(n.data+" ");
		}
	}
	
	
	public static void main(String[] args) {
		// Generic 타입이 아닌 : 구조체 배열 생성 방법
		treenode nodes[] = new treenode[num+1];
		for(int i=1; i <= num; i++) {
			treenode t1 = new treenode(i);
			nodes[i] = t1;
			nodes[i].leftchild = null;
			nodes[i].rightchild = null;
			
		}
		
		for(int i =2; i<=num; i++ ) {
			if( i %2 == 0) {
				nodes[i/2].leftchild = nodes[i];
			}else if(i %2== 1){
				nodes[i/2].rightchild = nodes[i];
			}
		}
		System.out.println("전위 순회 ");
		preorder(nodes[1]);
		System.out.println();
		
		System.out.println("중위 순회 ");
		midorder(nodes[1]);
		System.out.println();
		
		System.out.println("후위 순회 ");
		postorder(nodes[1]);
	}
}
