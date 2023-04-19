import java.util.Scanner;

public class Main20362 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();

        String[][] arr = new String[n][2];

        int idx = 0;
        String target = "";
        for(int i = 0; i < n; i++) {
            arr[i][0] = sc.next();
            arr[i][1] = sc.next();
            if(arr[i][0].equals(str)) {
                idx = i;
                target = arr[i][1];
            }
        }

        int answer = 0;
        for(int i = idx - 1; i >= 0; i--) {
            if(arr[i][1].equals(target)) answer++;
        }

        System.out.println(answer);
    }
}
