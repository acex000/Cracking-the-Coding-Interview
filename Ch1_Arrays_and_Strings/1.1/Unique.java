
public class Unique {
	static boolean b;
	public static void main(String[] args) {
		if(args.length==0)
			System.out.println("no input");
		else{
			String s = args[0];
			if(check(s))
				System.out.println("Unique");
			else
				System.out.println("Not Unique");
		}		
	}

	public static boolean check(String s){
		for(int i=0;i<s.length();i++){
			for(int j=i+1;j<s.length();j++){
				if(s.charAt(i)==s.charAt(j)){
					return false;
				}
			}
		}

		return true;
	}
}
