import java.util.Scanner;

public class Main2669 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[101][101];

        for(int i = 0; i < 4; i++) {
            int sy = sc.nextInt()+1;
            int sx = sc.nextInt()+1;
            int ey = sc.nextInt();
            int ex = sc.nextInt();

            for(int j = sx; j <= ex; j++) {
                for(int k = sy; k <= ey; k++) {
                    arr[j][k]++;
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i <= 100; i++) {
            for(int j = 0; j <= 100; j++) {
                if(arr[i][j] >= 1) cnt++;
            }
        }

        System.out.println(cnt);
    }
}
