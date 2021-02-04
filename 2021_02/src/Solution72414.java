//https://programmers.co.kr/learn/courses/30/lessons/72414
public class Solution72414 {
	static int change(String str) {
		String tmp[] = str.split(":");
		return Integer.parseInt(tmp[0]) * 3600 + Integer.parseInt(tmp[1]) * 60 + Integer.parseInt(tmp[2]);
	}

	public static String solution(String play_time, String adv_time, String[] logs) {
		 String answer = "";
	        if(play_time.equals(adv_time)) return "00:00:00";
	        int play = change(play_time);
	        int ad = change(adv_time);
	        int arr[] = new int[play+1];

	        for(int i = 0; i < logs.length; i++) {
	            String sp[] = logs[i].split("-");
	            int start = change(sp[0]);
	            int end = change(sp[1]);
	            arr[start]++;
	            arr[end]--;
	        }
	        int start = 1;
	        int end = 1;
	        long ans = 0;
	        long startSum = 0;
	        long endSum = 0;
	        long cnt = 0;
	        long val = 0;
	        while(true) {
	            if(ad <= cnt) {
	                startSum += arr[start];
	                start++;
	                cnt--;
	            } else if(end == play) break;
	            else {
	                endSum += arr[end-1];
	                end++;
	                cnt++;
	            }
	            if(ad == cnt) {
	                if(val < (startSum + endSum)) {
	                    val = (startSum + endSum);
	                    ans = start;
	                }
	            }
	        }
	        ans -= 1;
	        long a = ans / 3600;
	        long b = (ans % 3600) / 60;
	        long c = (ans % 3600) % 60;
	        if(a < 10) answer += "0";
	        answer += (a + ":");
	        if(b < 10) answer += "0";
	        answer += (b + ":");
	        if(c < 10) answer += "0";
	        answer += (c);
	        return answer;
	}

	public static void main(String[] args) {
		String p = "02:03:55";
		String a = "00:14:15";
		String l[] = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
		
		System.out.println(solution(p, a, l));
	}
}
