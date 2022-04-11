package GraPhrithm;

public class Progammers_Texi {
	public static void main(String[] args) {
		int n = 6;
		int s = 4;
		int a = 6;
		int b = 2;
		int [][] fares = { 
			{4, 1, 10},
			{3, 5, 24},
			{5, 6, 2},
			{3, 1, 41},
			{5, 1, 24},
			{4, 6, 50},
			{2, 4, 66},
			{2, 3, 22},
			{1, 6, 25}
		};
		Solution3_3_3 m = new Solution3_3_3();
		m.solution(n, s, a, b, fares);
	}
}
class Solution3_3_3 {
    int d[][] = new int[200][200]; // 200 * 200
    int INF = 98765421;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        // 초기화
        d = new int[n][n];
        for(int i = 0; i <n; i++){
            for(int j = 0; j <n; j++){
                if(i == j) d[i][j] = 0;
                else d[i][j] = INF;
            }
        }
        
        //fares에 잇는 것을 담아 넣기
        for(int[] fare : fares) {
            // 양방향
            d[fare[0] -1][fare[1] -1] = fare[2];
            d[fare[1] -1][fare[0] -1] = fare[2];
        }
        
        
        // 이제 지점들끼리 연결하며 짧은 거리로 합친다 (완성)
        for(int k = 0; k<n; k++){
            for(int i = 0; i <n; i++){
                for(int j = 0; j<n; j++){
                    // 만약 갈수 중간지점을 거쳐 갈수 있는 길이거나 더 짧은 거리가 있다면
                    if(d[i][j] > d[i][k] +d[k][j] ){
                        d[i][j] = d[i][k] + d[k][j] ;
                    }
                }
            }
        }
        // 배열을 0번부터 사용한다
        // 사용자는 1번부터 ~ n까지이므로 단위를 맞추기 위해 --
        s--;
        a--;
        b--;
        
        int answer = INF;
        // 어떤 중간지점을 타고 이동할까?
        for(int k = 0; k <n; k++){
            answer = Math.min(answer,d[s][k] + d[k][a] + d[k][b]);
        }
        // floyd warshall
        
        
        return answer;
    }
}