import java.util.Scanner;

public class Main1526 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        while(N > 0) {
            if(String.valueOf(N).contains("1") || String.valueOf(N).contains("2")
            || String.valueOf(N).contains("3") || String.valueOf(N).contains("5")
            || String.valueOf(N).contains("6") || String.valueOf(N).contains("8")
            || String.valueOf(N).contains("9") || String.valueOf(N).contains("0")) N--;
            else break;
        }
        System.out.println(N);
    }
}
