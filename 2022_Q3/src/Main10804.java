import java.util.Scanner;

public class Main10804 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[21];
        for(int i = 1; i < 21; i++) arr[i] = i;

        for(int i = 0; i < 10; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int[] tmp = new int[b-a+1];
            for(int j = 0; j < tmp.length; j++) tmp[j] = arr[a+j];

            for(int j = 0; j < tmp.length; j++) arr[b-j] = tmp[j];
        }

        for(int i = 1; i < 21; i++) System.out.print(arr[i] + " ");
    }
}
