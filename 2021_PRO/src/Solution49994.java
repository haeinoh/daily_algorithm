import java.util.HashMap;
import java.util.Map;

public class Solution49994 {
    public static Map<Character, Integer> map;
    public static boolean[][] vtd;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static int solution(String dirs) {
        int answer = 0;
        vtd = new boolean[10][10];
        map = new HashMap<>();
        map.put('U', 0);
        map.put('L', 1);
        map.put('D', 2);
        map.put('R', 3);

        int x = 5;
        int y = 5;

        for(int i = 0; i < dirs.length(); i++) {
            Character ch = dirs.charAt(i);

            int nx = x + dx[map.get(ch)];
            int ny = y + dy[map.get(ch)];

            if(nx < 0 || ny < 0 || nx >= 10 || ny >= 10) continue;
            if(!vtd[nx][ny]) answer++;
            System.out.println(" >> " + nx + " " + ny + " || " + vtd[nx][ny]);
            vtd[nx][ny] = true;
            x = nx;
            y = ny;
        }

        return answer;
    }

    public static void main(String[] args) {
        String d = "ULURRDLLU";
//        String d = "LULLLLLLU";
        System.out.println(solution(d));
    }
}
