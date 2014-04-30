public class SetOfStacksApp{

	public static void main(String[] args){
		SetOfStacks<Integer> setOfStk = new SetOfStacks<Integer>();
		System.out.println("sub stack size is 5");
		System.out.println("Right side is the top of the whole set of stacks:");
		for(int i=0;i<9;++i){
			setOfStk.push(i);
			System.out.print(i+",");
		}
		System.out.println();
		System.out.print("pop item: ");
		System.out.println(setOfStk.popAt(0));	//stack numbers starts from 0, which means the  first stack sequence number is 0;
												//here I set sub stack size to be 5, and in this exmple, there are 9 numbers(0~8) and
												//thus, all of them will be stored in two sub stacks(stack0 and stack1).
												//popAt(0) means pop out stack0's top item.
		while(!setOfStk.setIsEmpty()){
			System.out.println(setOfStk.pop());
		}
	}
}