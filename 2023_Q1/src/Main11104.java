import java.util.Scanner;

public class Main11104 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            String str = sc.next();
            int answer = 0;
            int val = 1;
            for(int j = str.length() - 1; j >= 0; j--) {
                answer += (val*(str.charAt(j)-'0'));
                val *= 2;
            }

            System.out.println(answer);
        }
    }
}
