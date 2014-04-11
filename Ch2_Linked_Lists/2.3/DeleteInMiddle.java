public class DeleteInMiddle{

	public static void deleteNode(LinkedListNode midNode){
		midNode.data = midNode.next.data;
		midNode.next = midNode.next.next;
	}

	public static void main(String[] args){
		LinkedListNode head = new LinkedListNode(0);
		
		for(int i=1;i<5;++i){
			head.addToTail(i);
		}
		LinkedListNode midNode = head.next.next;

		LinkedListNode runner = head;
		while(runner!=null){
			System.out.print(runner.data+",");
			runner = runner.next;	
		}
		System.out.println();
		deleteNode(midNode);
		runner = head;
		while(runner!=null){
			System.out.print(runner.data+",");
			runner = runner.next;	
		}
		System.out.println();


	}
}