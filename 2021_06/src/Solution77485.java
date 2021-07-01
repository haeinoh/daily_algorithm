public class Solution77485 {
    public static int[][] arr;
    public static  void init(int row, int col) {
        int num = 1;
        for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++)
                arr[i][j] = num++;
    }
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        arr = new int[rows][columns];
        init(rows, columns);

        for(int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];


        }


        return answer;
    }
    public static void main(String[] args) {
        int r = 6;
        int c = 6;
        int[][] q = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        System.out.println(solution(r, c, q));
    }
}
