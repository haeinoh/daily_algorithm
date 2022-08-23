import java.util.Scanner;

public class Main2947 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for(int i = 0; i < 5; i++) arr[i] = sc.nextInt();

        loop:for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 4; j++) {
                StringBuilder sb = new StringBuilder();
                int cnt = 0;
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    for(int k = 0; k < 5; k++) {
                        sb.append(arr[k]).append(" ");
                        if(arr[k] == (k+1)) cnt++;
                    }
                    System.out.println(sb.toString());
                }
                if(cnt == 5) break loop;
            }
        }
    }
}
