public class Solution12905 {
    static int solution(int[][] board) {
        int answer = 1;
        boolean flag = false;
        for (int[] ints : board) {
            for (int anInt : ints) {
                if (anInt == 1) {
                    flag = true;
                    break;
                }
            }
        }
        if(!flag)return 0;
        for(int i = 1; i < board.length; i++) {
            for(int j = 1; j < board[i].length; j++) {
                if(board[i][j] == 1) {
                    board[i][j] = Math.min(board[i-1][j-1], Math.min(board[i-1][j], board[i][j-1])) + 1;
                    answer = Math.max(answer, board[i][j]);
                }
            }
        }

        return answer*answer;
    }

    public static void main(String[] args) {
        int[][] b = {
                {0,1,1,1},
                {1,1,1,1},
                {1,1,1,1},
                {0,0,1,0}
        };
//        int[][] b = {
//                {0, 0, 1, 1},{1, 1, 1, 1}
//        };
        System.out.println(solution(b));
    }
}
