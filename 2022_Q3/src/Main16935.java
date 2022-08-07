import java.util.Scanner;

public class Main16935 {
    public static int N, M;
    public static int[][] arr;
    public static void copy(int[][] tmp, int count) {
        if(count == 2) {
            arr = new int[N][M];

        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                arr[i][j] = tmp[i][j];
            }
        }
    }
    public static void upanddown() {
        int[][] tmp = new int[N][M];

        for(int i = N-1; i >= 0; i--) {
            for(int j = 0; j < M; j++) {
                tmp[i][j] = arr[N-1-i][j];
            }
        }

        copy(tmp, 1);
    }

    public static void leftandright() {
        int[][] tmp = new int[N][M];

        for(int i = M-1; i >= 0; i--) {
            for(int j = 0; j < N; j++) {
                tmp[j][i] = arr[j][M-1-i];
            }
        }

        copy(tmp, 1);
    }

    public static void right90() {
        int temp = N;
        N = M;
        M = temp;
        int[][] tmp = new int[N][M];

        for(int i = M-1; i >= 0; i--) {
            for(int j = 0; j < N; j++) {
                tmp[j][i] = arr[M-1-i][j];
            }
        }

        copy(tmp, 2);
    }

    public static void left90() {
        int temp = N;
        N = M;
        M = temp;
        int[][] tmp = new int[N][M];

        for(int i = 0; i < M; i++) {
            for(int j = N-1; j >= 0; j--) {
                tmp[j][i] = arr[i][N-1-j];
            }
        }

        copy(tmp, 2);
    }


    public static void breakFour(int count) {
        int[][] tmp1 = new int[N/2][M/2];
        int[][] tmp2 = new int[N/2][M/2];
        int[][] tmp3 = new int[N/2][M/2];
        int[][] tmp4 = new int[N/2][M/2];

        for(int i = 0; i < N/2; i++) {
            for(int j = 0; j < M/2; j++) {
                tmp1[i][j] = arr[i][j];
            }
        }

        for(int i = 0; i < N/2; i++) {
            for(int j = M/2; j < M; j++) {
                tmp2[i][j-M/2] = arr[i][j];
            }
        }


        for(int i = N/2; i < N; i++) {
            for(int j = M/2; j < M; j++) {
                tmp3[i-N/2][j-M/2] = arr[i][j];
            }
        }

        for(int i = N/2; i < N; i++) {
            for(int j = 0; j < M/2; j++) {
                tmp4[i-N/2][j] = arr[i][j];
            }
        }

        if(count == 5) {
            // 1 -> 2
            for(int i = 0; i < N/2; i++) {
                for(int j = M/2; j < M; j++) {
                    arr[i][j] = tmp1[i][j-M/2];
                }
            }

            // 2 -> 3
            for(int i = N/2; i < N; i++) {
                for(int j = M/2; j < M; j++) {
                    arr[i][j] = tmp2[i-N/2][j-M/2];
                }
            }

            // 3 -> 4
            for(int i = N/2; i < N; i++) {
                for(int j = 0; j < M/2; j++) {
                    arr[i][j] = tmp3[i-N/2][j];
                }
            }

            // 4 -> 1
            for(int i = 0; i < N/2; i++) {
                for(int j = 0; j < M/2; j++) {
                    arr[i][j] = tmp4[i][j];
                }
            }
        } else {
            // 1 -> 4
            for(int i = N/2; i < N; i++) {
                for(int j = 0; j < M/2; j++) {
                    arr[i][j] = tmp3[i-N/2][j];
                }
            }

            // 4 -> 3
            for(int i = N/2; i < N; i++) {
                for(int j = M/2; j < M; j++) {
                    arr[i][j] = tmp4[i-N/2][j-M/2];
                }
            }

            // 3 -> 2
            for(int i = 0; i < N/2; i++) {
                for(int j = M/2; j < M; j++) {
                    arr[i][j] = tmp3[i][j-M/2];
                }
            }

            // 2 -> 1
            for(int i = 0; i < N/2; i++) {
                for(int j = 0; j < M/2; j++) {
                    arr[i][j] = tmp2[i][j];
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int R = sc.nextInt();

        arr = new int[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < R; i++) {
            int x = sc.nextInt();
            switch (x) {
                case 1:
                    upanddown();
                    break;
                case 2:
                    leftandright();
                    break;
                case 3:
                    right90();
                    break;
                case 4:
                    left90();
                    break;
                case 5:
                    breakFour(5);
                    break;
                case 6:
                    breakFour(6);
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

}
