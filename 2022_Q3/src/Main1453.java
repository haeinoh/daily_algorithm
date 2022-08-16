import java.util.Scanner;

public class Main1453 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean[] vtd = new boolean[101];
        int count = 0;
        for(int i = 0; i < N; i++) {
            int value = sc.nextInt();
            if(vtd[value]) count++;
            vtd[value] = true;
        }
        System.out.println(count);
    }
}
