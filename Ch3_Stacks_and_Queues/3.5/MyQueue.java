public class MyQueue<T>{

	MyStack<T> stackIn, stackOut;

	public MyQueue(){
		stackIn = new MyStack<T>();
		stackOut = new MyStack<T>();
	}

	public void enQueue(T item){
		stackIn.push(item);
	}

	public T deQueue(){
		if(stackOut.isEmpty()){
			dumpToStackOut();
		}
		T item = stackOut.pop();
		return item;
	}

	public T peek(){
		if(stackOut.isEmpty()){
			dumpToStackOut();
		}
		T item = stackOut.pop();
		return item;
	}

	public void dumpToStackOut(){
		stackOut.push(stackIn.pop());
	}

	public boolean isEmpty(){
		if(stackIn.isEmpty()&&stackOut.isEmpty()){
			return true;
		}
		else
			return false;
	}
}