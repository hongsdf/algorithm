package algorithm;

import java.util.ArrayList;
import java.util.List;

public class 피로도 {
	public static void main(String[] args) {
		int k = 80;
		int[][] dungeons = {{80,20},{50,40},{30,10}};
		SolutionA5 m = new SolutionA5();
		int ans = m.solution(k, dungeons);
		System.out.println(ans);
	}
	
}
class Point{
    int x;
    int y;
   // int z;
    Point(int x,int y){
        this.x = x;
        this.y = y;
     //   this.z = z;
    }
}

class SolutionA5 {
	public List<Point> list = new ArrayList<>();
//	public int min = 9999;
//	public int minidxv = 0; // x좌표중 최소 값
//	public int cnt = 0; //최종결과
	public int answer = 0 ; // 각 뿌리 정답값
	public boolean visit[];
    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
       
        //문제를 읽고 쉽다고 생각
        // 왜냐하면 문제가 이해되고, 탐욕법을 사용하는 것이라고 생각한다.
        // 던전 수는 8개이하 최대 64개
        
        //1 배열정렬 어떤순으로 정렬할것인가
        // 최소필요로도가 높은것을 우선으로 선택하는 것이 좋다
       
        
        // pointer(x,y,z)
        for( int[] curr :dungeons){
            int x = curr[0];
            int y = curr[1];
           // int z = curr[0]- curr[1];
            list.add(new Point(x,y));
        }
        
//        Collections.sort(list, new Comparator<Point>(){
//            public int compare(Point o1, Point o2){
//                if(o1.x == o2.x){
//                    return o2.z - o1.z;
//                }
//                return o2.x - o1.x;
//            }
//        });
        // x내림차순
        // y오름차순
        // z내림차순
        
        // 처음 위치에서 소모되는 값으로 k를 갱신하며 진행한다.
//        for(int i = 0; i <list.size(); i++){
//            Point curr = list.get(i);
//            if(k >= curr.x){ // 도전할수 있으면
//                k = curr.z; //도전하고 현재 hp
//                answer++;
//            }
//        }
        // 완전탐색
       
    	   // 재귀로 구현
        	dfs(0,k);
        
//    	   // i지점으로부터 모든지점을 탐색하여 가장최소 지점을 찾는다.
//    	   // 종료 조건 : k로 탐색할수 없으면 종료
//    	   for(int i = 0; i <list.size(); i++) {
//    		   if(!visit[i] &&  k >= list.get(i).x) {
//    			   answer = 0; // 각 뿌리의 정답값
//    			   k -= list.get(i).y;
//    			   dfs(i,k);
//    			   visitcheck(); //방문배열 초기화
//    			   cnt = Math.max(cnt, answer);
//    		   }
//    	   }
     
        
        
        
        return answer;
    }
	// 백트레킹 문제 판단
	private void dfs(int depth,int k) { // 현재 지점다음으로 최소비용
		
		for(int j=0; j<list.size() ; j++) {
			if(!visit[j] && list.get(j).x <= k ) {	 // 방문하지 않았고 탐색할 수 있는 범위라면		
				visit[j] = true;
				// k -= list.get(j).y;
				dfs(depth+1,k - list.get(j).y);
				visit[j] = false; // 다시 돌려놯야한다.
			}
		}
		
		answer = Math.max(answer, depth);
		
		
	
	
		
	}
}