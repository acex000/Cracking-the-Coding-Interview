import java.util.ArrayList;

public class MyStack<T>{
	private LinkedListNode<T> head=null;
	private int depth=0;

	public void push(T object){
		LinkedListNode<T> newItem = new LinkedListNode<T>(object);
		newItem.next = head;
		head = newItem;
		++depth;
	}

	public void pop(){
		head = head.next;
		--depth;
	}

	public T peek(){
		return head.data;
	}

	public boolean isEmpty(){
		if(depth==0)
			return true;
		else
			return false;
	}

	public int getDepth(){
		return depth;
	}
}