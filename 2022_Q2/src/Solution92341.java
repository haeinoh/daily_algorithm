import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class Solution92341 {

    public static int cal(String time) {
        String[] tmp = time.split(":");
        return Integer.parseInt(tmp[0])*60+Integer.parseInt(tmp[1]);
    }
    public static int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> inAndOut = new HashMap<>();
        TreeMap<String, Integer> accum = new TreeMap<>();

        for(int i = 0; i < records.length; i++) {
            String[] tmp = records[i].split(" ");
            int time = cal(tmp[0]);
            String carNum = tmp[1];

            if(tmp[2].equals("IN")) {
                inAndOut.put(carNum, time);
            } else {
                int accumTime = time - inAndOut.get(carNum);
                inAndOut.remove(carNum);
                accum.put(carNum, accum.getOrDefault(carNum, 0) + accumTime);
            }
        }

        if(!inAndOut.isEmpty()) {
            int time = cal("23:59");
            for(String carNum : inAndOut.keySet()) {
                int accumTime = time - inAndOut.get(carNum);
                accum.put(carNum, accum.getOrDefault(carNum, 0) + accumTime);
            }
        }
        int[] answer = new int[accum.size()];

        int idx = 0;
        for(String key: accum.keySet()) {
            int time = Math.max((accum.get(key) - fees[0]), 0);
            answer[idx] = fees[1] + (int)Math.ceil(time/(double)fees[2])*fees[3];
            idx++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] f = {180, 5000, 10, 600};
        String[] r = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(Arrays.toString(solution(f, r)));
    }
}
