
public class Solution17676 {

	public static void main(String[] args) {
		String[] lines = {"2016-09-15 01:00:04.002 2.0s","2016-09-15 01:00:07.000 2s"};
		String str[] = new String[3];
		
		for(int i = 0; i < lines.length; i++) {
			str = lines[0].split(" ");
			String time = str[1];
			String gap = str[2].replace("s", "");
			
			
		}
	}
}
