import java.util.Scanner;

public class Main2684 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            String str = sc.next();
            int[] arr = new int[8];
            for(int j = 0; j < str.length() - 2; j++) {
                String tmp = str.substring(j, j+3);
                switch (tmp) {
                    case "TTT": arr[0]++; break;
                    case "TTH": arr[1]++; break;
                    case "THT": arr[2]++; break;
                    case "THH": arr[3]++; break;
                    case "HTT": arr[4]++; break;
                    case "HTH": arr[5]++; break;
                    case "HHT": arr[6]++; break;
                    case "HHH": arr[7]++; break;
                }
            }
            for (int k : arr) sb.append(k).append(" ");
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }
}
