import java.util.LinkedList;
import java.util.Scanner;

public class Main16926 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();

        int[][] arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < Math.min(n,m)/2; i++){
                LinkedList<Integer> list = new LinkedList<>();
                for(int k = i; k < m-i; k++) list.add(arr[i][k]);
                for(int k = i+1; k < n-i-1; k++) list.add(arr[k][m-i-1]);
                for(int k = m-i-1; k >= i; k--) list.add(arr[n-i-1][k]);
                for(int k = n-i-2; k > i; k--) list.add(arr[k][i]);

//                System.out.println(list.toString());
                for(int k = 0; k < r; k++) list.addLast(list.removeFirst());

                for(int k = i; k < m-i; k++) arr[i][k] = list.removeFirst();
                for(int k = i+1; k < n-i-1; k++) arr[k][m-i-1] = list.removeFirst();;
                for(int k = m-i-1; k >= i; k--) arr[n-i-1][k] = list.removeFirst();
                for(int k = n-i-2; k > i; k--) arr[k][i] = list.removeFirst();
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
