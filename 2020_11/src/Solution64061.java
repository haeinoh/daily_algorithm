import java.util.ArrayList;

public class Solution64061 {
	public static int cpboard[][], cpmove[], box[], blen, count;
	public static ArrayList<Integer> list;
	
	public static void search(int x) {
		for(int i = 0; i < blen; i++) {
			if(cpboard[i][x] > 0) {
				list.add(cpboard[i][x]);
				cpboard[i][x] = 0;
				break;
			}
		}
	}
	
	public static void checkRemove() {
		for(int i = 1; i < list.size(); i++) {
			if(list.get(i) == list.get(i-1)) {
				list.remove(i);
				list.remove(i-1);
				count+=2;
			}
		}
	}
	
	public static void main(String[] args) {
		int board[][] = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int moves[] = {1,5,3,5,1,2,1,4};
		
		cpboard = board;
		cpmove = moves;
		count = 0;
		box = new int[901];
		list = new ArrayList<Integer>();
		blen = board[0].length;
		
		for(int i = 0; i < moves.length; i++) {
			search(moves[i]-1);
			checkRemove();
		}
		System.out.println(count);
	}
}
