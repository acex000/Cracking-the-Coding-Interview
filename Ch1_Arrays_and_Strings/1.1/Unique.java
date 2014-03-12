import java.lang.String;


public class Unique {
	static boolean b;
	public static void main(String[] args) {
		String s = args[0];
		
		b=check(s);
		if(b==true)
			System.out.println("Unique");
		else
			System.out.println("Not Unique");
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
