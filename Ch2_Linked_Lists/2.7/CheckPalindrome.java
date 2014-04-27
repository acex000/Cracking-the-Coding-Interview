public class CheckPalindrome{
	


	public static void check(LinkedListNode<Integer> head){
		LinkedListNode<Integer> slowPtr = head;
		// LinkedListNode<Integer> fastPtr = head.next;	//original thought:the first node is already the first step for slowptr, so fastptr should at the second node as its first pace
		LinkedListNode<Integer> fastPtr = head;	//new thought: set both of slow and fast to be head initially
		LinkedListNode<Integer> ptr = head;
		MyStack<LinkedListNode<Integer>> ms = new MyStack<LinkedListNode<Integer>>();
		// while(fastPtr.next!=null){	//original thought: use this loop when fastPtr initial value is head.next.

		// 	slowPtr = slowPtr.next;
		// 	fastPtr = fastPtr.next;
		// 	if(fastPtr.next!=null){
		// 		fastPtr = fastPtr.next;
		// 	}
		// }
		while(fastPtr.next!=null&&fastPtr.next.next!=null){	//new thought: changed the control logic in original though

			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}

		while(slowPtr.next!=null){
			slowPtr = slowPtr.next;
			ms.push(slowPtr);			
		}
		
		while(!ms.isEmpty()){	//if the stack can pop to empty continuously then it is a palindrome
			if(ms.peek().data==ptr.data){
				ms.pop();
				ptr = ptr.next;
			}
			else
				break;
		}
		
		if(ms.isEmpty())
			System.out.println("its a Palindrome");
		else
			System.out.println("its not a Palindrome");
	}

	public static void main(String[] args){
		LinkedListNode<Integer> head1 = new LinkedListNode<Integer>(1);
		LinkedListNode<Integer> head2 = new LinkedListNode<Integer>(1);
		LinkedListNode<Integer> head3 = new LinkedListNode<Integer>(1);
		//make two palindrome lists head1 and head2 with odd numbers of nodes and even numbers of nodes repectively
		for(int i=2;i<5;++i){
			head1.addToTail(i);
			head2.addToTail(i);
		}
		head2.addToTail(5);
		for(int i=4;i>0;--i){
			head1.addToTail(i);
			head2.addToTail(i);
		}
		//make a non-palindrome list head3
		for(int i=2;i<9;++i)
			head3.addToTail(i);

		head1.printList();
		head2.printList();
		head3.printList();

		check(head1);
		check(head2);
		check(head3);
	
	}
}