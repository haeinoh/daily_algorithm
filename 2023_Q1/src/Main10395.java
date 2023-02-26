import java.util.Scanner;

public class Main10395 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];

        for(int i = 0; i < 5; i++) arr[i] = sc.nextInt();
        boolean flag = true;
        for(int i = 0; i < 5; i++) {
            if(arr[i] == sc.nextInt()) flag = false;
        }
        if(flag) System.out.println("Y");
        else System.out.println("N");
    }
}
