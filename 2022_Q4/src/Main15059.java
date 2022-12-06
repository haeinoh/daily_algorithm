import java.util.Scanner;

public class Main15059 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int answer = 0;
        int aa = sc.nextInt();
        int bb = sc.nextInt();
        int cc = sc.nextInt();
        if(aa - a > 0) answer += (aa - a);
        if(bb - b > 0) answer += (bb - b);
        if(cc - c > 0) answer += (cc - c);

        System.out.println(answer);
    }
}
