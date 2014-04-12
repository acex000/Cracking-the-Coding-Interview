public class Partition{

	public static LinkedListNode partitionWithX(LinkedListNode head, int x){
		if(head==null||head.next==null)
			return head;

		LinkedListNode exNode = new LinkedListNode(x); // add a new node exNode to the list temporarily
		LinkedListNode preExNode=null;
		exNode.next = head;
		head = exNode;	//add exNode to become the first node of the list

		for(LinkedListNode current=head;current.next!=null;){
			LinkedListNode temp = current.next;
			if(temp.data<exNode.data){
				current.next = temp.next;
				temp.next = head;
				head = temp;
				if(temp.next==exNode){	// use preExNode to record the node just before exNode
					preExNode = temp;
				}
			}
			else{
				current=current.next;
			}
		}
		
		preExNode.next = exNode.next; //delete the exNode out of the list

		return head;
	}


	public static void main(String[] args){
	 	LinkedListNode head = new LinkedListNode(0);
	 	int x = 6;
	 	System.out.println("partition value x is "+x);
	 	for(int i=1;i<10;++i){
	 		head.addToTail(3*i%7);
	 	}
	 	for(LinkedListNode runner=head;runner!=null;runner=runner.next){
	 		System.out.print(runner.data+",");
	 	}
	 	System.out.println();

	 	head = partitionWithX(head, x);

	 	for(LinkedListNode runner=head;runner!=null;runner=runner.next){
	 		System.out.print(runner.data+",");
	 	}
	 	System.out.println();
	 }
}