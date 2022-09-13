import java.util.Scanner;

public class Main5533 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < N; i++) {
            int answer = 0;
            for(int j = 0; j < 3; j++) {
                boolean flag = false;
                for(int k = 0; k < N; k++) {
                    if(i == k) continue;
                    if(arr[i][j] == arr[k][j]) {
                        flag = true;
                        break;
                    }
                }
                if(!flag) answer += arr[i][j];
            }
            System.out.println(answer);
        }
    }
}
