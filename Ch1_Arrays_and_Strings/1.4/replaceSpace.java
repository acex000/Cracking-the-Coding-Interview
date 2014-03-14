
public class ReplaceSpace {


	public static void main(String[] args){
		
		String str = "Mr John Smith     ";
		int length = 13;
		char[] charArr = str.toCharArray();
		
		replace(charArr,length);
		System.out.println(new String(charArr));
	}

	public static void replace(char[] charArr, int length){

		int spaceCount=0;
		for(int i=0;i<length;i++){
			if(charArr[i]==' ')
				++spaceCount;
		}
		
		int newLength = length+spaceCount*2;
		
		charArr[newLength]='\0';

		for(int i=length-1, j=newLength-1;i>=0;--i,--j){
			if(charArr[i]==' '){
				charArr[j]='0';
				--j;
				charArr[j]='2';
				--j;
				charArr[j]='%';
			}
			else {
				charArr[j]=charArr[i];
			}
		}		
	}
}