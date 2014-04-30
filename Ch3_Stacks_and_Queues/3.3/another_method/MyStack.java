public class MyStack<T>{
	LinkedListNode<T> top = null;
	int depth = 0;
	int size = 5;

	public void push(T object) throws Exception{
		LinkedListNode<T> newItem = new LinkedListNode<T>(object);
		if(isEmpty()){
			top = newItem;
		}
		else if(!isEmpty()&&!isFull()){
			newItem.next = top;
			top = newItem;
		}
		else if(isFull){
			throw new Exception("this stack is full");
		}
	}

	public boolean isFull(){
		if(depth>=size)
			return true;
		else
			return false;
	}

	public boolean isEmpty(){
		if(depth==0)
			return true;
		else 
			return false;
	}
}