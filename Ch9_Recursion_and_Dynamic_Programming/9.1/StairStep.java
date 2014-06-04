public class StairStep{

	public static int countWays(int num, int[] arr){
		if(num==0)
			return 1;
		else if(num<0)
			return 0;

		if(arr[num]==0)
			arr[num] = countWays(num-1, arr) + countWays(num-2, arr) + countWays(num-3, arr);
		return arr[num];
	}

	public static void main(String[] args){
		int num = 4;
		int[] arr = new int[num+1];
		System.out.println(countWays(num, arr));
	}
}