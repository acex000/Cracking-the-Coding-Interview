
public class checkPermutation {


	public static void main(String[] args){
		
		String str1 = "abcd!@#";
		String str2 = "!cba@#dgh";
		String longStr, shortStr;
		Boolean str1Islonger = true;

		if(str1.length()>=str2.length()){
			longStr = str1;
			shortStr = str2;

		}
		else {
			longStr = str2;
			shortStr = str1;
			str1Islonger = false;
		}

		if(check(longStr, shortStr)){
			if(str1Islonger)
				System.out.println("str2 is a permutation of str1");
			else
				System.out.println("str1 is a permutation of str2");
		}
		else {
			System.out.println("None of these two strings is a permutaion of the other");
		}

	}


	public static boolean check(String longStr, String shortStr){
		int[] char_set = new int[256]; //in java all int elements are default to be zero

		for(int i=0;i<longStr.length();i++){
			if(i<shortStr.length()){
				int val = shortStr.charAt(i);
				--char_set[val];
			}

			int val = longStr.charAt(i);
			++char_set[val];
		}

		for(int j: char_set){
			if(j<0)
				return false;
		}
		return true;
	}
}