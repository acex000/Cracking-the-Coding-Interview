public class LinkedListNode<T>{
	public LinkedListNode<T> next =null;
	public LinkedListNode<T> pre = null;
	public T data;

	public LinkedListNode(T data){
		this.data = data;
	}

	public void addToTail(T newData){
		LinkedListNode<T> pointer = this;

		while(pointer.next!=null){
			pointer = pointer.next;
		}
		LinkedListNode<T> newNode = new LinkedListNode<T>(newData);
		pointer.next=newNode;
		newNode.pre = pointer;
	}

	public LinkedListNode<T> addToHead(T newData){
		LinkedListNode<T> pointer = this;
		LinkedListNode<T> newNode = new LinkedListNode<T>(newData);
		newNode.next = pointer;
		pointer.pre = newNode;
		return newNode;
	}

	public void printList(){
		LinkedListNode<T> runner = this;
		while(runner!=null){
			System.out.print(runner.data+",");
			runner = runner.next;
		}
		System.out.println();
	}
}