import java.util.Scanner;

public class Main1991 {
	public static int N;
	public static char arr[][];

	public static void preorder(char ch) {
		System.out.print(ch);
		if(arr[ch-'A'][0] != '.') preorder(arr[ch-'A'][0]);
		if(arr[ch-'A'][1] != '.') preorder(arr[ch-'A'][1]);
	}

	public static void inorder(char ch) {
		if(arr[ch-'A'][0] != '.') inorder(arr[ch-'A'][0]);
		System.out.print(ch);
		if(arr[ch-'A'][1] != '.') inorder(arr[ch-'A'][1]);
	}

	public static void postorder(char ch) {
		if(arr[ch-'A'][0] != '.') postorder(arr[ch-'A'][0]);
		if(arr[ch-'A'][1] != '.') postorder(arr[ch-'A'][1]);
		System.out.print(ch);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new char[27][2];

		for (int i = 0; i < N; i++) {
			char a = sc.next().charAt(0);
			char b = sc.next().charAt(0);
			char c = sc.next().charAt(0);
			arr[a - 'A'][0] = b; // left
			arr[a - 'A'][1] = c; // right
		}
		
		preorder('A');
		System.out.println();
		inorder('A');
		System.out.println();
		postorder('A');
	}
}
