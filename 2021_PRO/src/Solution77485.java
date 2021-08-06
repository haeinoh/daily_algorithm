import java.util.Arrays;
import java.util.LinkedList;

public class Solution77485 {
    static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int index = 1;
        int[][] arr = new int[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                arr[i][j] = index++;
            }
        }

        LinkedList<Integer> list = new LinkedList<>();

        for(int p = 0; p < queries.length; p++) {
            int x1 = queries[p][0] - 1;
            int y1 = queries[p][1] - 1;
            int x2 = queries[p][2] - 1;
            int y2 = queries[p][3] - 1;
            answer[p] = 987654321;
            for(int i = y1; i <= y2; i++) {
                list.add(arr[x1][i]);
                answer[p] = Math.min(answer[p], arr[x1][i]);
            }
            for(int i = x1+1; i <= x2; i++) {
                list.add(arr[i][y2]);
                answer[p] = Math.min(answer[p], arr[i][y2]);
            }
            for(int i = y2-1; i >= y1; i--) {
                list.add(arr[x2][i]);
                answer[p] = Math.min(answer[p], arr[x2][i]);
            }
            for(int i = x2-1; i >= x1+1; i--) {
                list.add(arr[i][y1]);
                answer[p] = Math.min(answer[p], arr[i][y1]);
            }
            list.addFirst(list.removeLast());

            int idx = 0;
            for(int i = y1; i <= y2; i++) arr[x1][i] = list.get(idx++);
            for(int i = x1+1; i <= x2; i++) arr[i][y2] = list.get(idx++);
            for(int i = y2-1; i >= y1; i--) arr[x2][i] = list.get(idx++);
            for(int i = x2-1; i >= x1+1; i--) arr[i][y1] = list.get(idx++);

            list.clear();
        }
        return answer;
    }

    public static void main(String[] args) {
        int r = 3;
        int c = 3;
        int[][] q = {{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}};
        System.out.println(Arrays.toString(solution(r, c, q)));
    }
}
