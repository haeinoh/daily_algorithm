import java.util.HashSet;
import java.util.Scanner;

public class Main25757 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String game = sc.next();

        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            set.add(sc.next());
        }

        int answer = 0;
        switch (game) {
            case "Y":
                answer = set.size() / 1;
                break;
            case "F":
                answer = set.size() / 2;
                break;
            case "O":
                answer = set.size() / 3;
                break;
        }
        System.out.println(answer);
    }
}
