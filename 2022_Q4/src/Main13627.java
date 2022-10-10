import java.util.Scanner;

public class Main13627 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int R = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < R; i++) {
            arr[sc.nextInt()-1] = 1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            if(arr[i] == 0) sb.append(i+1).append(" ");
        }
        if(sb.toString().equals("")) sb.append("*");

        System.out.println(sb.toString());
    }
}
