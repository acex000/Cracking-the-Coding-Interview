public class BitsInsert{

	public static void insert(int a, int b, int start, int end){
		int mask = (~((~(~0<<(end-start+1)))<<start)); //use this mask to set bits from start though end to be 0 with & operation
		printIntToBits(a);
		a &= mask;
		printIntToBits(b);
		b <<= start;

		a |= b;
		printIntToBits(a);
	}

	public static void printIntToBits(int number){
		
		System.out.println(String.format("%32s", Integer.toBinaryString(number)).replace(' ', '0'));
	}

	public static void main(String[] args){
		int a = 1234567;
		int b = 15;

		insert(a, b, 3, 8);
	}
}