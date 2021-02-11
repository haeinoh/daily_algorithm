//https://programmers.co.kr/learn/courses/30/lessons/17683
import java.util.ArrayList;

public class Solution17683 {
    public static String solution(String m, String[] musicinfos) {
        String answer = "";
        int prevTime = 0;
        ArrayList<String> music = new ArrayList<>();
        int index = 0;
        for(int k = 0; k < m.length(); k++) {
            char ch = m.charAt(k);
            if(ch == '#') {
                music.set(index-1, music.get(index-1)+ch);
            } else {
                music.add(String.valueOf(ch));
                index++;
            }
        }
        for(int i = 0; i < musicinfos.length; i++) {
            String info[] = musicinfos[i].split(",");
            int time = (Integer.parseInt(info[1].split(":")[0])*60 + Integer.parseInt(info[1].split(":")[1]))
                    - (Integer.parseInt(info[0].split(":")[0])*60 + Integer.parseInt(info[0].split(":")[1]));

            ArrayList<String> list = new ArrayList<>();

            int idx = 0;
            for(int k = 0; k < info[3].length(); k++) {
                char ch = info[3].charAt(k);
                if(ch == '#') {
                    list.set(idx-1, list.get(idx-1)+ch);
                } else {
                    list.add(String.valueOf(ch));
                    idx++;
                }
            }
            for(int k = 0; k <= time - music.size(); k++) {
                int tmp = k;
                boolean flag = false;
                for(int j = 0; j < music.size(); j++) {
                    if(list.get(tmp++%list.size()).equals(music.get(j))) continue;
                    else{
                        flag = true;
                        break;
                    }
                }
                if(!flag) {
                    if(prevTime < time) {
                        prevTime = time;
                        answer = info[2];
                    }
                }
            }
        }
        if(("").equals(answer)) return "(None)";
        return answer;
    }

    public static void main(String[] args) {
        String m = "ABC";
        String mu[] = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(solution(m, mu));
    }
}
