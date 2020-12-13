import java.util.Arrays;

public class Solution17676 {

	public static void main(String[] args) {
		String[] lines = {"2016-09-15 00:00:00.000 2.3s", "2016-09-15 23:59:59.999 0.1s"}; //test용
		int answer = 0;

		String str[] = new String[3];
		double store[][] = new double[lines.length][2]; //store start, end
		double start = 0; //minStart
		
		for(int i = 0; i < lines.length; i++) {
			str = lines[i].split(" "); // split first
			double time = 0;
 			String t1 = str[1]; // calc time
			String cal[] = t1.split(":");
			time += (3600*Double.parseDouble((cal[0])) + 60*Double.parseDouble((cal[1])) + Double.parseDouble(cal[2]));
			
			String g1 = str[2].replace("s", ""); //gap 
			double gap = Double.parseDouble(g1);
			store[i][0] = Double.parseDouble(String.format("%.3f", (time-gap+0.001)));
			store[i][1] =  Double.parseDouble(String.format("%.3f", (time)));
		}

		double next = 0;
		for(int i = 0; i < lines.length; i++) {
			int count = 0;
			start = store[i][1];
			next =  Double.parseDouble(String.format("%.3f", (start + 0.999))); //0.999->1
			for(int j = 0; j < lines.length; j++) {
				if(store[j][1] >= start && next >= store[j][0]) // start보다는 크거나 같고 next보다는 작게
					count++;
			}
			if(answer < count) answer = count;
		}
		System.out.println("answer " + answer);
	}
}
