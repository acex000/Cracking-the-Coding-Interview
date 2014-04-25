public class ListSumLtoR{
	private static LinkedListNode sumResult = new LinkedListNode(0);
	private static LinkedListNode sRunner = sumResult;

	public static void sumList(LinkedListNode head1, LinkedListNode head2){
		
		int digitSum = 0;
		int remainderNum = 0;
		int flipNum = 0;
		
		if(head1!=null&&head2!=null){
			remainderNum = (head1.data+head2.data+sRunner.data)%10;
			flipNum = (head1.data+head2.data+sRunner.data)/10;
			sRunner.data = remainderNum;
			if(head1.next!=null||head2.next!=null||flipNum!=0){
				sRunner.next = new LinkedListNode(flipNum);
				sRunner = sRunner.next;		
				sumList(head1.next, head2.next);	
			}

		}
		else if(head1==null&&head2!=null){
			remainderNum = (head2.data+sRunner.data)%10;
			flipNum = (head2.data+sRunner.data)/10;
			sRunner.data = remainderNum;
			if(head2.next!=null||flipNum!=0){
				sRunner.next = new LinkedListNode(flipNum);
				sumList(head1, head2.next);
			}
		}
		else if(head1!=null&&head2==null){
			remainderNum = (head1.data+sRunner.data)%10;
			flipNum = (head1.data+sRunner.data)/10;
			sRunner.data = remainderNum;
			if(head1.next!=null||flipNum!=0){
				sRunner.next = new LinkedListNode(flipNum);
				sumList(head1.next, head2);
			}
		}
		
	}

	public static void main(String[] args){
		LinkedListNode head1 = new LinkedListNode(1);
		LinkedListNode head2 = new LinkedListNode(5);
		LinkedListNode runner = null;
		runner = head1;	//generate head1 list
		for(int i=2;i<4;++i){
			head1.addToTail(i);
			runner = runner.next;
		}

		head1.printList();

		runner = head2;	//generate head2 list
		for(int i=6;i<9;++i){
			head2.addToTail(i);
			runner = runner.next;
		}

		head2.printList();

		sumList(head1,head2);

		sumResult.printList();

	}


}