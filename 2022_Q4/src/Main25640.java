import java.util.Scanner;

public class Main25640 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String base = sc.next();
        int n = sc.nextInt();
        int answer = 0;
        for(int i = 0; i < n; i++) {
            if(base.equals(sc.next())) answer++;
        }
        System.out.println(answer);
    }
}
