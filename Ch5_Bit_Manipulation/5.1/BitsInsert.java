//In this question, the portion we are requied to insert starts from start+1 bit to end+1 bit(both start+1 bit and end +1 bit are included)
//I dont why the author give a rule like this...
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