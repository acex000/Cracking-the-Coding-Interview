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

	public T pop(){
		if(head!=null){
			T item = head.data;
			head = head.next;
			--depth;
			return item;
		}
		return null;
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

	public LinkedListNode<T> getTopNode(){
		return head;
	}

	public void printStack(){
		LinkedListNode<T> ptr = head;
		while(ptr!=null){
			System.out.print(ptr.data+",");
			ptr = ptr.next;
		}
		System.out.println();
	}
}