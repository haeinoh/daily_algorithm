import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution42888 {
    public static String[] solution(String[] record) {
        Map<String, String> name = new HashMap<>();
        String[][] arr = new String[record.length][2];
        int idx = 0;

        for(int i = 0; i < record.length; i++) {
            String[] tmp = record[i].split(" ");
            String order = tmp[0];
            String id = tmp[1];
            String nm = "";
            if(!order.equals("Leave")) nm = tmp[2];

            if(!order.equals("Change")) {
                arr[idx][0] = id;
                arr[idx][1] = order;
                idx++;
            }
            if(!order.equals("Leave")) {
                if(name.get(id) != null) name.put(id, nm);
                else name.put(id, nm);
            }
        }
        String[] answer = new String[idx];
        for(int i = 0; i < idx; i++) {

            if(arr[i][1].equals("Enter")) answer[i] = name.get(arr[i][0]) + "님이 들어왔습니다.";
            else answer[i] = name.get(arr[i][0]) + "님이 나갔습니다.";
        }

        return answer;
    }
    public static void main(String[] args) {
        String[] r = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(r)));
    }
}
