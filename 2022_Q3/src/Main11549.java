import java.util.Scanner;

public class Main11549 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int answer = 0;
        for(int i = 0; i < 5; i++) {
            if(T == sc.nextInt()) answer++;
        }
        System.out.println(answer);
    }
}
