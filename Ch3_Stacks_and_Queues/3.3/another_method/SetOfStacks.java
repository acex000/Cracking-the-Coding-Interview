public class SetOfStacks<T>{

	// not finished yet
	// this method use a list of stacks to implement the requirement.
	LinkedListNode<MyStack<T>> stkListTop = null;
	int stackNum = 0;

	public void push(T object){
		if(stackNum=0){
			stkListTop = new LinkedListNode<MyStack<T>>(new MyStack<T>());
			stkListTop.data.push(object);
		}
		else if(stackNum!=0){
			if(stackNum.data.isFull()){
				LinkedListNode<MyStack<T>> newStk = new LinkedListNode<MyStack<T>>();
				newStk.next = stkListTop;
				stkListTop = newStk;
			}
		}
	}
	

}