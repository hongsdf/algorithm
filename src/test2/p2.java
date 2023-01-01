package test2;

public class p2 {
	public static void main(String[] args) {
		Solutionp2 m = new Solutionp2();
		int[][] office = {{5,-1,4},{6,3,-1},{2,-1,1}};
		//int[][] office = {{4,3,-1,8},{6,-1,1,7},{3,4,2,4},{2,-1,3,6}};
		int r =  1;
		int c = 0; 
		String[] move = {"go","go","right","go","right","go","left","go"};
		int answer = m.solution(office, r, c, move);
		System.out.println(answer);
	}
}
class Solutionp2 {
    public int N;
    public int answer = 0;
    public int solution(int[][] office, int r, int c, String[] move) {
       // 사무실을 청소하려고 한다.
       // 사전 명령어에 의해 움직인다.
       // go : 현재 바라보고 있는 방향으로 한칸 전진
       // left
       // right

       // 결과 청소를 한후 먼지양을 리턴

       // 20  * 20
       // 북 -> 동 -> 남 -> 서
        N = office.length;
        solve(r,c,move,office);
        // check() 0의 갯수 세기
        //check(office);
        return answer;
    }

    public void solve(int row, int col,String[] command,int[][] office){
        // right 오른쪽 회전
        // left 왼쪽 회전
    	answer +=  office[row][col];// 현재칸 청소
    	office[row][col] = 0;
        int direction = 1; // 현재 바라 보고 잇는 방향
        // 1 : 북
        // 2:  동
        // 3:  남
        // 4:  서
        int currRow = row;
        int currCol = col;
        for(int i = 0;i<command.length; i++){
            String comm = command[i]; // 명령어를 하나꺼냄
            if(comm.equals("go")){
                // 현재 방향도 가지고 있어야함
                if(direction == 1){
                    if(currRow-1 >= 0 && office[currRow-1][currCol] != -1){
                        answer += office[currRow-1][currCol];
                    	office[currRow-1][currCol] = 0;
                    	currRow = currRow-1;
                    	
                    }
                }else if(direction == 2){
                    if(currCol+1 < N && office[currRow][currCol+1] != -1){
                    	answer += office[currRow][currCol+1];
                        office[currRow][currCol+1] = 0;
                        currCol = currCol +1;
                    }
                }else if(direction == 3){
                    if(currRow+1 < N && office[currRow+1][currCol] != -1){
                    	answer += office[currRow+1][currCol];
                        office[currRow+1][currCol] = 0;
                        currRow = currRow +1;
                    }
                }else if(direction == 4){
                    if(currCol - 1>= 0 && office[currRow][currCol-1] != -1){
                    	answer += office[currRow][currCol-1];
                        office[currRow][currCol-1] = 0; 
                        currCol = currCol -1;
                    }
                }
              
            }else if(comm.equals("right")){
                if(direction == 1){
                    direction = 2;
                    // 현재 위치 변경
                    
                }else if(direction == 2){
                    direction = 3;
                }else if(direction == 3){
                    direction = 4;
                }else if(direction == 4){
                    direction = 1;
                }
            }else{ // left
                 if(direction == 1){
                    direction = 4;
                }else if(direction == 2){
                    direction = 1;
                }else if(direction == 3){
                    direction = 2;
                }else if(direction == 4){
                    direction = 3;
                }
            }

        }
    }
//    public void check(int[][] office){
//        for(int i = 0; i <office.length; i++){
//            for(int j = 0; j <office.length; j++){
//                if(office[i][j] == 0){
//                    answer++;
//                }
//            }
//        }
//    }
}