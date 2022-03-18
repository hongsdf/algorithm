package Union;
// union (합치다) + Find(찾다)
// union find : 서로 같은 부모를 가리키나? , 서로 연결되어있나?
public class unionFind {
	public static void main(String[] args) {
		int array[] = new int[11];
		for(int i =1; i<array.length; i++) {
			array[i] = i;
		}
		union(array,1,2);
		union(array,2,3);
		union(array,3,4);
		union(array,7,8);
		union(array,8,5);
		union(array,9,10);
		
		boolean flag = SameNode(array,1,8);
		System.out.println(flag);
	}
	
	// union(더 작은 값으로 합치기)
	public static void union(int[] array, int a, int b) {
		a = getParent(array,a);
		b = getParent(array,b);
		if(a < b) array[b] = a;
		else array[a] = b;
		
	}
	
	// 부모 찾기
	// 재귀식
	public static int getParent(int[] array , int a) {
		if(array[a] == a) return a; // 배열값 == 자신의 값이 같으면 부모
		return array[a] = getParent(array, array[a]) ;
	}
	
	// 같은 부모인지(같은 길 인지 판단)
	public static boolean SameNode(int[] array, int a, int b) {
		a = getParent(array, a);
		b = getParent(array, b);
		if(a == b) return true; // 서로 같은 부모(길)
		else {
			return false;// 서로 다른 부모(길)
		}
		
	}
}
