import java.util.Scanner;

public class Main1408 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] cur = sc.next().split(":");
        String[] tim = sc.next().split(":");

        StringBuilder sb = new StringBuilder();
        int hour = 0;
        if(Integer.parseInt(cur[0]) <= Integer.parseInt(tim[0])) {
            hour = Integer.parseInt(tim[0]) - Integer.parseInt(cur[0]);
        } else {
            hour = (Integer.parseInt(tim[0]) + 24) - Integer.parseInt(cur[0]);
        }

        int min = 0;
        if(Integer.parseInt(cur[1]) <= Integer.parseInt(tim[1])) {
            min = Integer.parseInt(tim[1]) - Integer.parseInt(cur[1]);
        } else {
            min = (Integer.parseInt(tim[1]) + 60) - Integer.parseInt(cur[1]);
            hour--;
        }

        int sec = 0;
        if(Integer.parseInt(cur[2]) <= Integer.parseInt(tim[2])) {
            sec = Integer.parseInt(tim[2]) - Integer.parseInt(cur[2]);
        } else {
            sec = (Integer.parseInt(tim[2]) + 60) - Integer.parseInt(cur[2]);
            min--;
            if(min < 0) {
                hour--;
                min = 59;
            }
        }

        if(hour < 10) sb.append("0").append(hour);
        else sb.append(hour);
        sb.append(":");

        if(min < 10) sb.append("0").append(min);
        else sb.append(min);
        sb.append(":");

        if(sec < 10) sb.append("0").append(sec);
        else sb.append(sec);

        System.out.println(sb.toString());
    }
}
