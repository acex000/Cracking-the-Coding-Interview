public class ListSumRtoL{
	public static int lengthDiff = 0; //the length difference between the two list
	public static int count = 0;	//a mirror variable used to comparing with lengthDiff
	public static LinkedListNode newList = new LinkedListNode(0);
	public static LinkedListNode longerList;
	public static LinkedListNode shorterList;
	//core function that do the summation work recursively
	public static void sumList(LinkedListNode longerList, LinkedListNode shorterList){
		int digitSum = 0;
		int remainderNum = 0;
		int filpNum = 0;
		if(longerList.next==null&&shorterList.next==null){		//recursion bottom condition
			digitSum = longerList.data+shorterList.data+newList.data;
			remainderNum = digitSum%10;
			filpNum = digitSum/10;
			newList.data = remainderNum;
			newList = newList.addToHead(filpNum);
		}
		else {
			if(count!=0){
				--count;
				sumList(longerList.next, shorterList);
				++count;
				digitSum = longerList.data+newList.data;
				remainderNum = digitSum%10;
				filpNum = digitSum/10;
				newList.data = remainderNum;
				if(!(count==lengthDiff&&filpNum==0))
					newList = newList.addToHead(filpNum);
			}
			else if(count==0){
				sumList(longerList.next, shorterList.next);
				digitSum = longerList.data+shorterList.data+newList.data;
				remainderNum = digitSum%10;
				filpNum = digitSum/10;
				newList.data = remainderNum;
				newList = newList.addToHead(filpNum);
			}
		}
	}
	//calculate the length difference between the two list and save into variable lengthDiff
	public static void calculateDiff(LinkedListNode head1, LinkedListNode head2){
		LinkedListNode ptr1=head1;
		LinkedListNode ptr2=head2;
		for(;ptr1!=null||ptr2!=null;){
			if(ptr1==null||ptr2==null){
				++lengthDiff;
				if(ptr1==null){
					longerList=head2;
					shorterList=head1;
				}
				else if(ptr2==null){
					longerList=head1;
					shorterList=head2;
				}
			}
			if(ptr1!=null)
				ptr1 = ptr1.next;
			if(ptr2!=null)
				ptr2 = ptr2.next;
		}
		count = lengthDiff;
		System.out.println("length difference:"+lengthDiff);

	}
	//check if there is any null list between these two lists
	public static void checkIfNull(LinkedListNode head1, LinkedListNode head2){
		if(head1==null&&head2!=null){
			newList = head2;
			newList.printList();
		}
		else if(head2==null&&head1!=null){
			newList = head1;
			newList.printList();
		}
		else if(head1==null&head2==null)
			System.out.println("both of the two list is null");
		else if(head1!=null&&head2!=null){
			calculateDiff(head1,head2);
			sumList(longerList,shorterList);
			newList.printList();
		}
	}

	public static void main(String[] args){
		LinkedListNode head1 = new LinkedListNode(3);
		LinkedListNode head2 = new LinkedListNode(6);

		for(int i=0;i<7;++i){
			head1.addToTail((2*i+1)%9);
		}
		head1.printList();
		for(int i=0;i<5;++i){
			head2.addToTail((3*i+1)%9);
		}
		head2.printList();

		checkIfNull(head1, head2);

	}	
}