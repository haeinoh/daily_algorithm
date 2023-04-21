import java.util.Scanner;

public class Main2484 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0;

        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            int sum = 0;

            if(a == b && b == c && c == d) sum = 50000 + a*5000;
            else if(a == b && b == c) sum = 10000 + a*1000;
            else if(b == c && c == d) sum = 10000 + b*1000;
            else if(a == c && c == d) sum = 10000 + a*1000;
            else if(a == b && b == d) sum = 10000 + a*1000;
            else if((a == b) && (c == d)) sum = (2000 + a*500 + c*500);
            else if((b == c) && (a == d)) sum = (2000 + b*500 + a*500);
            else if((a == c) && (b == d)) sum = (2000 + b*500 + a*500);
            else if(a == b) sum = (1000 + a*100);
            else if(b == c) sum = (1000 + b*100);
            else if(a == c) sum = (1000 + a*100);
            else if(a == d) sum = (1000 + a*100);
            else if(b == d) sum = (1000 + b*100);
            else if(c == d) sum = (1000 + c*100);
            else sum = (Math.max(a, Math.max(b, Math.max(c, d))))*100;
            
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
