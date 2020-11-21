//https://www.acmicpc.net/problem/14891

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main14891 {
	public static int T;
	public static LinkedList<Integer> list[];
	
	public static void left(int num, int rot) {
		if(num-1 >= 0 && list[num-1].get(2) != list[num].get(6)) {
			left(num-1, -rot);
			rotate(num-1, rot);
		}
	}
	
	public static void right(int num, int rot) {
		if(num+1 < T && list[num+1].get(6) != list[num].get(2)) {
			right(num+1, -rot);
			rotate(num+1, rot);
		}
	}
	
	public static void rotate(int num, int rot) {
		if(rot == 1) list[num].addFirst(list[num].pollLast()); 
		else list[num].addLast(list[num].pollFirst());		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		T = 4;
		list = new LinkedList[T];
		for(int i = 0; i < T; i++) list[i] = new LinkedList();
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			String str = st.nextToken();
			for(int j = 0; j < 8; j++) {
				list[i].add(Character.getNumericValue(str.charAt(j)));
			}
		}
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int R = Integer.parseInt(st.nextToken());
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken())-1;
			int r = Integer.parseInt(st.nextToken());
			
			left(n, -r);
			right(n, -r);
			rotate(n, r);
		}
		
		count += list[0].get(0) == 0 ? 0 : 1;
		count += list[1].get(0) == 0 ? 0 : 2;
		count += list[2].get(0) == 0 ? 0 : 4;		
		count += list[3].get(0) == 0 ? 0 : 8;

		System.out.println(count);
	}
}
