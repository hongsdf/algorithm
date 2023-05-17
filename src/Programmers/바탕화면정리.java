package Programmers;

public class 바탕화면정리 {
	public static void main(String[] args) {
		SolutionA3 m = new SolutionA3();
		String[] wallpaper = {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
		String[] wallpaper = {"..........", ".....#....", "......##..", "...##.....", "....#....."};
//
		int answer[] = m.solution(wallpaper);
		for(int ans : answer) {
			System.out.println(ans);
		}
	}
}
class SolutionA3 {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        // 목적 : 최소한의 이동거리를 갖는 한 번의 드래그로 모든 파일을 선택해서 한 번에 지우려고 하며 드래그로 파일들을 선택하는 방법
        int colstart = 51; 
        int colend = -1;
        
        int rowStart = 51; //최소값
        int rowEnd = -1; // 최소값
        
        // 탐색 방법
        for(int i = 0; i<wallpaper.length;i++){
            String index = wallpaper[i];
           for(int j = 0; j <index.length(); j++){
               if(index.charAt(j) == '#'){
                   if(colstart > j){
                       colstart = j;
                   }
                   if(colend < j ){
                       colend = j;
                   }
               }
           }
        }
        
        
        
        for(int i = 0; i<wallpaper.length;i++){
            String index = wallpaper[i];
           for(int j = 0; j <index.length(); j++){
               if(index.charAt(j) == '#'){
                   if(rowStart > i){
                       rowStart = i;
                   }
                   if(rowEnd < i ){
                       rowEnd = i;
                   }
               }
           }
        }
        answer[0] = rowStart;
        answer[1] = colstart;
        answer[2] = rowEnd+1;
        answer[3] = colend+1;
       
       
        
        return answer;
    }
}