public class LinkedListNode{
	public LinkedListNode next =null;
	public int data;

	public LinkedListNode(int data){
		this.data = data;
	}

	public void addToTail(int newData){
		LinkedListNode pointer = this;
		while(pointer.next!=null){
			pointer = pointer.next;
		}
		LinkedListNode newNode = new LinkedListNode(newData);
		pointer.next=newNode;
	}
}