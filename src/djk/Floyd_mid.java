package djk;

public class Floyd_mid {

}
class Solution {
    // floyd
    int Board[][] = new int[200][200];
    static final int INF = 4000000; // 최대 요금은 100,000 // 두배열을 연결하기 때문에 두지저만 거리100,000
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = INF;
        // 보드 초기화
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(i == j) Board[i][j] = 0;
                else Board[i][j] = INF;
            }
        }
        // Board에 fares정보 갱신
       // fares에 있는 것을 옮김
        
        // 매개변수가 2차원 배열이면 ==> * 확장 반복문으로 꺼낸다.*
     // fares[] = {c,d,f}형태로 주어진다.
        for(int[] edge : fares) {
               // 1 (edge[0]) 2 (edge[1]) 5 (edge[2])
               // 양방향 그래프
               Board[edge[0]-1][edge[1]-1] = edge[2];
               Board[edge[1]-1][edge[0]-1] = edge[2];
            
         }
        
        floyd(n);
        // s,a,b에서의 단위랑 Board랑 맞춰 주기
        // s : 1 -->  Board[0]
        // s : 5, a :3 --> Board[5-1][3-1] 
        s--;
        a--;
        b--;
        //  0 0 0 0 0 0
        //  0 0 0 0 0 0
        //  0 0 0 0 0 0
        //  0 0 0 0 0 0
        //  0 0 0 0 0 0
        
        // 모든 노드가 중간지점이 된다
        // Greedy() : 핵심 모든 것을 전부 탐색한다
        for(int k = 0; k < n;k++){
            // 출발지점 -> 중간지점 -> a지점 -> b지점
          answer  = Math.min(answer , Board[s][k] + Board[k][a] + Board[k][b]);  
        }
       
        
        
        return answer;
    }
 
    public void floyd(int n){
        for(int k = 0; k< n; k++){ 
          for(int i = 0; i <n; i++){
             for(int j = 0; j<n; j++){
                 if(Board[i][j] > Board[i][k] + Board[k][j]){
                     Board[i][j] = Board[i][k] + Board[k][j];
                 }
             }
          }
        }
		
    }
}