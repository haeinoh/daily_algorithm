import java.util.ArrayList;

public class Solution17683 {
    public static String solution(String m, String[] musicinfos) {
        String answer = "";

        for(int i = 0; i < musicinfos.length; i+=4) {

            int time = Integer.parseInt(musicinfos[i+1].split(":")[0] + musicinfos[i+1].split(":")[1])
                    - Integer.parseInt(musicinfos[i].split(":")[0]+musicinfos[i].split(":")[1]);
            System.out.println("time " + time);

            // musicinfos[i+3] -> split C, C#, ...
            ArrayList<String> list = new ArrayList<>();
            for(int k = 0; k < musicinfos[i+3].length(); k++) {
                if(musicinfos[i+3].charAt(k) == '#') {
                    System.out.println(list.get(k-1));
                    String str = list.get(k-1);
                    str += String.valueOf(musicinfos[i+3].charAt(k));
                    list.add(k-1, str);
                } else list.add(String.valueOf(musicinfos[i+3].charAt(k)));
            }
            System.out.println(list.toString());
            if(time >= musicinfos[i+3].length()) {

            } else {

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String m = "CC#BCC#BCC#BCC#B";
        String mu[] = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        System.out.println(solution(m, mu));
    }
}
