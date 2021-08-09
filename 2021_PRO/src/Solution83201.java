// weekly challenge (week2)
public class Solution83201 {
    static String solution(int[][] scores) {
        StringBuilder sb = new StringBuilder();

        for(int j = 0; j < scores.length; j++) {
            int my = scores[j][j];
            int sum = 0;
            int min = 987654321;
            int max = 0;
            for(int i = 0; i < scores[j].length; i++) {
                if(i == j) continue;
                sum += scores[i][j];
                min = Math.min(min, scores[i][j]);
                max = Math.max(max, scores[i][j]);
            }
            if(min > my || max < my) sum /= (scores[j].length - 1);
            else sum = (sum + my) / scores[j].length;

            if(sum >= 90) sb.append("A");
            else if(sum >= 80) sb.append("B");
            else if(sum >= 70) sb.append("C");
            else if(sum >= 50) sb.append("D");
            else sb.append("F");
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        int[][] s = {{70,49,90}, {68,50,38}, {73, 31, 100}};
        System.out.println(solution(s));
    }
}
