package algorithm; 
import java.util.*;

class Solutionb6a {
    public List<List<int[]>> GameBoard_List = new ArrayList<>();
    public boolean GameVisit[][];
    public List<List<int[]>> Table_List = new ArrayList<>();
    public boolean TableVisit[][];
    
    
    public int dx[] = {-1,1,0,0};
    public int dy[] = {0,0,-1,1};
    
    public int answer = 0;
    public int solution(int[][] game_board, int[][] table) {
        // 완전탐색 문제 + 배열회전 + 배열 위치조정(배열이 존재하는 위치는 다르지만 비교할때는 상대위치로 조정해야한다. 이때 가장 왼쪽위 지점을 0,0으로 땡겨 상대위치를 만든다.)
        
        // Point객체가 아닌 int[] 배열로 선언하였다 그이유는 Point객체는 인덱스가 없어 값을 수정하기 위해 인덱스가 존재하는 int[] 배열이 필요하다. 회전시마다 값이 변할때 인덱스 위치에다 값을 대입함
        
        GameVisit = new boolean[game_board.length][game_board.length];
        TableVisit = new boolean[table.length][table.length];
        // 구현 game_board 0의 위치를 찾는다.
        for (int i = 0; i < table.length; i++){
            for (int j = 0; j < table.length; j++){

                if (table[i][j] == 1 && !TableVisit[i][j]){
                    bfs(i, j, TableVisit, table, 1, Table_List);
                }

                if (game_board[i][j] == 0 && !GameVisit[i][j]){
                    bfs(i, j, GameVisit, game_board, 0, GameBoard_List);
                }
            }
        }
        // 구현 table안에서 1의 위치를 찾는다.
        

        
        
        // check함수를 통해 game_board 조각들과 table의 조각들을 비교한다.
        check(GameBoard_List,Table_List);        
        
        
        return answer;
    }
    //bfs 탐색 시도
    // 탐색을 하면서 연결되는 위치값을 큐에 넣고
    // 상대위치로 변환하기 위해 시작점 row,col을 (-빼기)를 하여 상대위치를 조정한다.
    // 처음 들어온 지점은 무조건 0,0이 된다.  ex)3,2 -> 3-3,2-2 => (0,0)
    public void bfs(int row, int col,boolean [][] visit,int[][] board,int number,List<List<int []>> list){
        Queue<int[]> q =new LinkedList<>();
        q.add(new int[]{row,col});
        List<int[]> sub = new ArrayList<>();
        sub.add(new int[]{row-row,col-col});
        visit[row][col] = true;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            for(int i = 0; i <4; i++){
               int nx = curr[0] + dx[i];
               int ny = curr[1] + dy[i];
               if(nx >=0  && nx<board.length && ny >=0 && ny < board.length ){
                   if(!visit[nx][ny] && board[nx][ny] == number){
                       q.add(new int[]{nx,ny});
                       sub.add(new int[]{nx-row,ny-col});
                       visit[nx][ny] = true;
                   }
               } 
            }
        }
        list.add(sub);
        
    }

    
    // check 
    // 서로의 조각 갯수가 다를 수 있다.
    // 기준은 game_board갯수가 된다.
    
    // 조각 모음을 비교하여 같은 갯수인것을 찾으면 cycle메서드를 실행한다.
    public void check(List<List<int[]>> GameBoard_List,List<List<int[]>> Table_list){
        int Gsize = GameBoard_List.size();
        int Tsize = Table_list.size();
        boolean visit[] = new boolean[Gsize];
        
        for(int i = 0; i <Tsize; i++) {
            List<int[]> tab = Table_list.get(i);
            for(int j = 0; j <Gsize; j++){
            	List<int[]> game = GameBoard_List.get(j);
                if(game.size() == tab.size() && !visit[j]){
                    if(cycle(game,tab)){
                        answer += game.size();
                        visit[j] = true;
                        break;
                    }
                        
                }
            }
        }
    }
    
    // cycle
    // 서로의 조각들이 같은지 비교 같지 않으면 회전 90->180->270 ->360 회전한다.
    // 이때 회전이 되면 1,0 -> 0,-1 처럼 (가장 왼쪽위 상단) 기준점이 변하므로 회전시 마다 정렬을 해주어야한다.
    public boolean cycle(List<int[]> game,List<int[] > table){
        boolean isCorrect = false;
        
//        table.sort((o1,o2)->{
//        	return o1[0] > o2[0]?1 :o1[0] < o2[0]? -1 : Integer.compare(o1[1], o2[1]);
//        });
        Collections.sort(game,new Comparator<int[]>(){
           public int compare(int[] o1,int o2[]){
               if(o1[0] == o2[0]){
                   return o1[1] - o2[1];
               }
               return o1[0] - o2[0];
           } 
        });
        
        // 회전 90 ->180 ->270 -> 360
        for(int i = 0; i <4; i++){
        Collections.sort(table,new Comparator<int[]>(){
           public int compare(int[] o1,int o2[]){
               if(o1[0] == o2[0]){
                   return o1[1] - o2[1];
               }
               return o1[0] - o2[0];
           } 
        });
//        table.sort((o1,o2)->{
//        	return o1[0] > o2[0]?1 :o1[0] < o2[0]? -1 : Integer.compare(o1[1], o2[1]);
//        });
        
           
        int nX = table.get(0)[0];
        int nY = table.get(0)[1];
            
         for(int j = 0; j <table.size(); j++){
             table.get(j)[0] -= nX;
             table.get(j)[1] -= nY;
         }
         
            boolean flag = true;
            
        for(int j = 0; j <table.size(); j++){
              int [] Table = table.get(j);
              int [] Game  = game.get(j) ;
            
                if(Table[0] != Game[0] || Table[1] != Game[1]){
                    flag = false;
                    break;
                }
        }    
        if(flag){
            isCorrect = true;
            break;
            
        }else{ // 회전이 필요함
            for(int j=0; j<table.size(); j++){
               int temp  = table.get(j)[0];
                table.get(j)[0] = table.get(j)[1];
                table.get(j)[1] = -temp;
            }
             
        } 
            
            
        }
        return isCorrect;
        
    }
    // 원소가 일치하면 answer++증가 시킨다.
    
}