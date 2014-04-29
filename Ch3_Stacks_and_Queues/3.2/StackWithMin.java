public class StackWithMin{

	public static void main(String[] args){
		StackM stkM = new StackM();
		for(int i=1;i<8;++i){
			stkM.push(3*i%5);
			System.out.print(3*i%5+",");
		}
		System.out.println();
		System.out.println("Stack & minList:");
		while(!stkM.isEmpty()){
			System.out.print(stkM.peek()+",");
			System.out.println(stkM.getMin());
			stkM.pop();
		}
		System.out.println();
	}
}