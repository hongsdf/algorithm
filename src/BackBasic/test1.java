package BackBasic;

import java.io.*;
import java.util.*;

public class test1 {
    private static int n, m;
    private static int answer = Integer.MIN_VALUE;
    private static int[][] board;
    private static boolean[][] visited;
    private static int[] dr = {1, -1, 0, 0};
    private static int[] dc = {0, 0, 1, -1};


    public static void main(String[] args) throws IOException {
        input();
        solution(0, 0, 0);
        System.out.println(answer);
    }

    private static void solution(int selectRow, int selectColumn, int count) {
        if (count == 3) {
            bfs();
            return;
        }
        for (int row = selectRow; row < n; row++) { // ¿©±â row = 0
            for (int column = 0; column < m; column++) {
                if (row == selectRow && column <= selectColumn) continue;
                if (board[row][column] == 0) {
                    board[row][column] = 1;
                    solution(row, column, count + 1);
                    board[row][column] = 0;
                }
            }
        }
    }

    private static void bfs() {
        initVisited();
        Queue<Position> queue = new LinkedList<>();
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < m; column++) {
                if (board[row][column] == 2) {
                    queue.add(new Position(row, column));
                    visited[row][column] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Position current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextRow = current.getRow() + dr[i];
                int nextColumn = current.getColumn() + dc[i];
                if (nextRow >= n || nextRow < 0|| nextColumn >= m || nextColumn < 0) continue;
                if (board[nextRow][nextColumn] == 0 && !visited[nextRow][nextColumn]) {
                    queue.offer(new Position(nextRow, nextColumn));
                    visited[nextRow][nextColumn] = true;
                }
            }
        }

        answer = Math.max(answer, countSafeArea());
    }

    private static void initVisited() {
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < m; column++) {
                if (board[row][column] == 0) {
                    visited[row][column] = false;
                } else {
                    visited[row][column] = true;
                }
            }
        }
    }

    private static int countSafeArea() {
        int count = 0;
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < m; column++) {
                if (!visited[row][column]) count++;
            }
        }
        return count;
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new boolean[n][m];
        for (int row = 0; row < n; row++) {
            st = new StringTokenizer(br.readLine());
            for (int column = 0; column < m; column++) {
                board[row][column] = Integer.parseInt(st.nextToken());
                if (board[row][column] == 1) visited[row][column] = true;
            }
        }
    }

    static class Position {
        private final int row;
        private final int column;

        public Position(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }
    }
}