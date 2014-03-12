public class Solution1 {
	static boolean b;
	public static void main(String[] args){
		
		if(args.length==0)
			System.out.println("No string input");
		else{
			String s = args[0];
			if(checkCharUnique(s))
				System.out.println("Unique");
			else
				System.out.println("Not Unique");
		}
		
	}

	public static boolean checkCharUnique(String str){
		if(str.length()>256)
			return false;
		boolean[] char_set = new boolean[256];
		for(int i =0;i<str.length();i++){
			int val = str.charAt(i);
			if(char_set[val])
				return false;
			else
				char_set[val] = true;
		}
		return true;
	}
}
