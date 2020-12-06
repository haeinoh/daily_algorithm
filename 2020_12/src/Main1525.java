//https://www.acmicpc.net/problem/1525
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1525 {
	public static int answer;
	public static boolean flag;
	public static String base;
	public static HashSet<String> set;
	public static Queue<String> q;
    public static int dx[] = {-1, 1, -3 ,3};
    
    public static String swap(String sb, int cur, int next) {
    	StringBuilder tmp = new StringBuilder(sb);
    	char c = tmp.charAt(cur);
    	char n = tmp.charAt(next);
    	
    	tmp.setCharAt(cur, n);
    	tmp.setCharAt(next, c);
    	
    	return tmp.toString();
    }
    
    public static void solve() {
    	loop:while(!q.isEmpty()) {
    		int size = q.size(); 
    		lop:while(size > 0) {
    			String str = q.poll();
    			int x = str.indexOf("0");
    			if(str.equals("123456780")) {
    				flag = true;
    				break lop;
    			}
    			for(int i = 0;i < dx.length; i++) {
    				int nx = x + dx[i];
    				
    				if(nx < 0 || nx >= 9 || (i == 1 && (x+1)%3 == 0 ) || (i == 0 && x % 3 == 0)) continue;
    				else {
    					String next = swap(str, x, nx);
    					if(!set.contains(next)) {
    						set.add(next);
    						q.add(next);
    					}
    				}
    			}
    			size--;
    		}
    		if(flag) break loop;
    		answer++;
    	}
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        q = new LinkedList<>();
        flag = false;
        answer = 0;
        base = "";
        for(int i = 0 ; i <3; i++) {
        	for(int j = 0; j < 3; j++) {
        		int x= sc.nextInt();
        		base += x;
        	}
        }
        set = new HashSet<>();
        q.add(base);
        set.add(base);
        solve();
        if(flag) System.out.println(answer);
        else System.out.println("-1");
    }
}