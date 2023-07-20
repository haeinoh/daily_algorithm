import java.util.Scanner;

public class Main28289 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int first = 0;
        int sw = 0;
        int emb = 0;
        int ai = 0;

        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if(a == 1) first++;
            else if(b == 1 || b == 2) sw++;
            else if(b == 3) emb++;
            else if(b == 4) ai++;
        }
        System.out.println(sw);
        System.out.println(emb);
        System.out.println(ai);
        System.out.println(first);
    }
}
