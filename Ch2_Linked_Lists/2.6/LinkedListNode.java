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

	public LinkedListNode addToHead(int newData){
		LinkedListNode pointer = this;
		LinkedListNode newNode = new LinkedListNode(newData);
		newNode.next = pointer;
		return newNode;
	}

	public void printList(){
		LinkedListNode runner = this;
		while(runner!=null){
			System.out.print(runner.data+",");
			runner = runner.next;
		}
		System.out.println();
	}
}