import java.util.Hashtable;

public class FindLoopPoint{

	public static void findPoint(LinkedListNode head){
		Hashtable<LinkedListNode,Integer> ht = new Hashtable<LinkedListNode,Integer>();
		LinkedListNode ptr = head;
		LinkedListNode runner = head;
		int count=1;
		while(ptr.next!=null){
			if(ht.containsKey(ptr)){
				break;	//if break happens, then ptr will pointing the loop beginning node
			}
			else{
				ht.put(ptr,ptr.data);
				ptr = ptr.next;
			}
		}

		while(runner!=ptr){
			runner = runner.next;
			++count;
		}
		System.out.println("the "+count+"th node is the loop beginning node, its value is "+ptr.data);
	}

	public static void main(String[] args){
		LinkedListNode head = new LinkedListNode(0);
		LinkedListNode tail = head;
		LinkedListNode loopPoint = head;
		for(int i=1;i<10;++i){
			head.addToTail(i);
		}
		head.printList();

		while(tail.next!=null){
			tail = tail.next;
		}

		for(int i=0;i<5;++i){
			loopPoint = loopPoint.next; // loopPoint now is at the 6th node with value 5;
		}
		System.out.println(loopPoint.data);
		tail.next = loopPoint; //make a loop between tail and the 6th node

		findPoint(head);

	}
}