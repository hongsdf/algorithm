package algorithm;

public class 퍼즐조각채우기 {

}
class SolutionB6{
    public int solution(int[][] game_board, int[][] table) {
        // 조각은 한 번에 하나씩 채워 넣습니다.
        // 조각을 회전시킬 수 있습니다.
        // 조각을 뒤집을 수는 없습니다.
        // 게임 보드에 새로 채워 넣은 퍼즐 조각과 인접한 칸이 비어있으면           안 됩니다.
        
        
        // 구현
        // 1. table을 순환하여 Map<Integer,List<Point>> 지점으로 저장한다.
        // 2.원본 배열에서 0인지점을 dfs로 탐색하여 크기를 측정한다.
        // 2-1이때 Map안에서 size에 맞는 Point들을 탐색을 하는데
        // 위치가 맞지 않으면 90 -> 180 ->270 회전을 시켜서 확인하다.
        // 문제 : Point의 위치값과 원본배열 0이 발견된 지점의 위치값이 서로 다르다. 그래서 위치값을 일치시켜놓고 진행하야한다.
        

        
        
        
        int answer = -1;
        return answer;
    }
}

