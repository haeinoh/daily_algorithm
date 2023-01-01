import java.util.Scanner;

public class Main10823 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while(sc.hasNextLine()) {
            String str = sc.nextLine();
            if("".equals(str) ||  str.contains("\n")) break;
            sb.append(str);
        }

        String[] str = sb.toString().split(",");
        int answer = 0;
        for (String s : str) answer += Integer.parseInt(s);

        System.out.println(answer);
    }
}
