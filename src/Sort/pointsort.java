package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


// 좌표 정렬 문제 
// (1,2)
// (2,5)
// (2,6)
// (1,1)
// (2,3)
// (3,3)
// (3,1)
// (3,2)
class comparepoint implements Comparator<pointx>{

	@Override
	public int compare(pointx o1, pointx o2) {
		if(o1.x != o2.x) {
			return o2.x - o1.x;
		}else {
			return o2.y - o1.y;
		}
		
		
		
		
	}
	
}




class pointx{
	int x;
	int y;
	
	pointx(int x, int y){
		this.x = x;
		this.y = y;
	}
	
}

public class pointsort {
	public static void main(String[] args) {
		pointx p1 = new pointx(1,2);
		pointx p2 = new pointx(3,7);
		pointx p3 = new pointx(3,2);
		pointx p4 = new pointx(3,1);
		pointx p5 = new pointx(3,3);
		pointx p6 = new pointx(2,3);
		pointx p7 = new pointx(1,1);
		pointx p8 = new pointx(2,6);
		pointx p9 = new pointx(2,5);
		
		List<pointx> list =  new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(new pointx(3,2));
		list.add(new pointx(3,1));
		list.add(new pointx(3,3));
		list.add(new pointx(2,3));
		list.add(new pointx(1,1));
		list.add(p8);
		list.add(p9);
		
		
		
		Collections.sort(list,new comparepoint());
		System.out.println("여기");
		for(int i =0; i<list.size(); i++) {
			System.out.println(list.get(i).x+" "+list.get(i).y);
		}
	}
	
}
