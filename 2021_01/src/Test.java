
public class Test {

	public static void main(String[] args) {
		System.out.println(1 << 6);
		
		System.out.println('a' - 'a'); // 0 
		System.out.println('b' - 'a'); // 1
		System.out.println('c' - 'a'); // 2
		System.out.println('d' - 'a'); // 3
		System.out.println('e' - 'a'); // 4
		System.out.println('f' - 'a'); // 5
		System.out.println("----------- ");
		
		System.out.println('A' - 'A'); // 0
		System.out.println('B' - 'A'); // 1
		System.out.println('C' - 'A'); // 2
		System.out.println('D' - 'A'); // 3
		System.out.println('E' - 'A'); // 4
		System.out.println('F' - 'A'); // 5
		System.out.println("----------- ");

		System.out.println(1 <<  ('c' - 'a')); // 1을 ('c' - 'a')만큼 왼쪽으로 쉬프트 
		System.out.println(Integer.toBinaryString(1 << ('f' - 'a')));
	
		System.out.println("??? " + (1| (1 << ('b' - 'a'))));
		int key = (1| (1 << ('b' - 'a')));
		//or연산자 치면  모든 걸 포함 가능 
		System.out.println("------");
		System.out.println((3 & (1 << ('b' - 'a'))));

	}
}
