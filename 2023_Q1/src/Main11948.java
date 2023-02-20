import java.util.Scanner;

public class Main11948 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int min = 987654321;
        for(int i = 0; i < 4; i++) {
            int value = sc.nextInt();
            min = Math.min(value, min);
            sum += value;
        }
        sum -= min;
        sum += Math.max(sc.nextInt(), sc.nextInt());
        System.out.println(sum);
    }
}
