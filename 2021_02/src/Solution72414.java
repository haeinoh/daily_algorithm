//https://programmers.co.kr/learn/courses/30/lessons/72414
public class Solution72414 {
	static int change(String str) {
		String tmp[] = str.split(":");
		return Integer.parseInt(tmp[0]) * 3600 + Integer.parseInt(tmp[1]) * 60 + Integer.parseInt(tmp[2]);
	}

	public static String solution(String play_time, String adv_time, String[] logs) {
		String answer = "";
		if (play_time.equals(adv_time))
			return "00:00:00";
		int play = change(play_time);
		int ad = change(adv_time);
		int arr[] = new int[play + 1];

		for (int i = 0; i < logs.length; i++) {
			String sp[] = logs[i].split("-");
			int start = change(sp[0]);
			int end = change(sp[1]);
			for (int j = start; j <= end; j++)
				arr[j]++;
		}
		int start = 0;
		int end = 0;
		int ans = 0;
		int sum = 0;
		int cnt = 0;
		int val = 0;
//      System.out.println("answer : " + change("01:30:59"));
		while (start < play) {
			if (ad <= cnt) {
				sum -= arr[start++];
				cnt--;
			} else if (end == play)
				break;
			else {
				sum += arr[end++];
				cnt++;
			}
			if (ad == cnt) {
				if (val < sum) {
					val = sum;
					ans = start;
				}
			}
		}
		// ans-=1;
		int a = ans / 3600;
		int b = (ans % 3600) / 60;
		int c = (ans % 3600) % 60;
		if (a < 10)
			answer += "0";
		answer += (a + ":");
		if (b < 10)
			answer += "0";
		answer += (b + ":");
		if (c < 10)
			answer += "0";
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
