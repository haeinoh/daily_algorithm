import java.util.Scanner;

public class Main11945 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            while(sc.hasNext()) {
                System.out.println(new StringBuilder(sc.next()).reverse());
            }
        }
        sc.close();
    }
}