import java.util.Scanner;

public class Main13866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[4];
        for(int i = 0; i < 4; i++) arr[i] = sc.nextInt();
        System.out.println(Math.abs((arr[2]+arr[1]) - (arr[3]+arr[0])));
    }
}
