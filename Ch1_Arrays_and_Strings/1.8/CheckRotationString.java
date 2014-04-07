public class CheckRotationString{

	public static void main(String[] args){
		String s1 = "this is a string";
		String s2 = "is a stringthis ";

		checkRotation(s1, s2);
	}

	public static boolean  isSubString(String s1, String s2){
		if(s1.contains(s2))
			return true;
		else 
			return false;
	}

	public static void checkString(String s1, String s2){
		int matchDigit = 0;
		boolean matchStart = false;
		for(int i=0;i<s2.length();++i){
			if(s2.charAt(i)==s1.charAt(matchDigit)){
				matchStart = true;
				++matchDigit;
			}
			else{
				matchStart = false;
				matchDigit = 0;
			}
		}

		if(isSubString(s1.substring(matchDigit), s2.substring(0,matchDigit)))
			System.out.println("s2 is a rotation of s1");
		else
			System.out.println("s2 is not a rotation of s1");
	}

	public static void checkRotation(String s1, String s2){
		
		if(s1.length()!=s2.length())
			System.out.println("s2 is not a rotation of s1");
		else
			checkString(s1, s2);	
	}
}
