import java.util.Scanner;

public class Main21567 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();

        String sum = String.valueOf(a * b * c);

        int[] arr = new int[10];
        for(int i = 0; i < sum.length(); i++) {
            arr[sum.charAt(i)-'0']++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
