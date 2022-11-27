package algorithm;

public class 네트워크 {

}
/*
 *  dfs로 같은 그래프인지 체크하는 목적
 *  재귀함수로 구현
 *  목적 : 출발지점에서 이어지는 모든 지점 방문체크하기
 *  탈출 조건 : 출발지점과 이어지는 모든지점을 체크하면
 *  
 *  n개중 출발지점을 선택하여 재귀함수를 구현한다. for문 구현 재귀함수가 하나식 실행될때마다 이어진 그래프가 완성되고 answer++증가
 * 	시간 복잡도 O( n^2 )
 *   
 * 
 */

class SolutionA4 {
    public boolean visit[]; // 방문표시
    public int answer = 0; // 정답
    public int n;
    public int solution(int n, int[][] computers) {
        visit = new boolean[n];
        
        answer = 0;
        for(int i = 0; i < n; i++){
            if(!visit[i]){
                dfs(i,n,computers);   // 재귀함수로 구현할것이다.
                answer++; //그룹수++
            }
        }
        
        
        // 인접행령에 대하여
        // 재귀함수로 구현할것이다.
        // 방문한적이 없거나 && 연결되어 있다면 cnt++
        return answer;
    }
    public void dfs(int curr,int n,int[][] computers){
        if(visit[curr]) return; // 탈출조건
        visit[curr] = true;
        // 목적: curr와 연결된 목록을 모두 방문체크한다.
        for(int i = 0; i <n; i++){
            if(!visit[i] && computers[curr][i] == 1 && computers[i][curr] == 1){
                dfs(i,n,computers);
            }
        }
    }
    
}