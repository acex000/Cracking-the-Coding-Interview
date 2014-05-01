public class SortStack{

	public static void main(String[] args) {
		
		MyStack<Integer> myStack = new MyStack<Integer>();
		MyStack<Integer> stack2 = new MyStack<Integer>();
		for(int i=1;i<10;++i){
			myStack.push(3*i%5);
		}
		myStack.printStack();

		stack2 = sort(myStack, stack2);
		stack2.printStack();
	}

	public static MyStack<Integer> sort(MyStack<Integer> myStack, MyStack<Integer> stack2){
		while(!myStack.isEmpty()){
			int item = myStack.pop();
			stack2 = insertInto(item, stack2);
		}
		return stack2;
	}


	public static MyStack<Integer> insertInto(Integer item, MyStack<Integer> stack2){
		if(!stack2.isEmpty()&&(item<stack2.peek())){
			int temp = stack2.pop();
			stack2 = insertInto(item, stack2);
			stack2.push(temp);	
			return stack2;		
		}
		else{
			stack2.push(item);
			return stack2;
		}

	}
}