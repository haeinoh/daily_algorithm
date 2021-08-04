
public class Solution49994 {
    public static boolean[][][][] vtd;
    public static int solution(String dirs) {
        int answer = 0;
        vtd = new boolean[11][11][11][11];
        int x = 0;
        int y = 0;
        for(int i = 0; i < dirs.length(); i++) {
            char ch = dirs.charAt(i);
            int nx = x;
            int ny = y;
            switch (ch) {
                case 'U':
                    if(ny + 1 <= 5) ny += 1;
                    else continue;
                    break;
                case 'L':
                    if(nx - 1 >= -5) nx -= 1;
                    else continue;
                    break;
                case 'D':
                    if(ny - 1 >= -5) ny -= 1;
                    else continue;
                    break;
                case 'R':
                    if(nx + 1 <= 5) nx += 1;
                    else continue;
                    break;
            }
            if (!vtd[nx+5][ny+5][x+5][y+5]){
                vtd[x+5][y+5][nx+5][ny+5] = true;
                vtd[nx+5][ny+5][x+5][y+5] = true;
                answer++;
            }
            x = nx;
            y = ny;
        }
        return answer;
    }

    public static void main(String[] args) {
        String d = "UUUUDUDUDUUU";
//        String d = "UDU";
        System.out.println(solution(d));
    }
}
