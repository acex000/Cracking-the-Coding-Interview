import java.util.*;

public class StringCompression{

	public static void main(String[] args){
		String str = "aabcccccaaa";
		String cStr = compression(str);

		if(cStr.length()>=str.length())
			System.out.println("finale string:"+str);
		else
			System.out.println("finale string:"+cStr);

	}

	public static String compression(String str){
		char[] chArr = str.toCharArray();
		StringBuilder newStr = new StringBuilder();
		char temp = '\0';
		
		boolean startChar = true;
		int count=0;

		for(int i=0;i<chArr.length;i++){
			
			if(temp == chArr[i]){
				
				++count;
			}
			else {
				if(startChar){
					startChar = false;	
				}
				else	{
					newStr.append((char)('0'+count));
				}
				newStr.append(chArr[i]);
				temp = chArr[i];				
				count = 1;
			}
		}
		
		newStr.append((char)('0'+count));
		
		return newStr.toString();
	}
}