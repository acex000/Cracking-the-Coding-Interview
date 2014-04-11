//used self defined LinkedListNode to construct a linkedlist to solve this problem
//used recursion
public class KthNodeToLast2{
	private static int kth=3;
	private static int count=1;

	public static void GetKthToLast(LinkedListNode llNode){
		
		if(llNode.next!=null){
			GetKthToLast(llNode.next);
			if(count==kth){
				System.out.println(kth+"th to last element is "+llNode.data);
			}
			++count;
		}
		else
			++count;
	}

	public static void main(String[] args){
		LinkedListNode llNode = new LinkedListNode(0);
		LinkedListNode Runner;
		int count = 0;
		int kth = 3;
		for(int i=1;i<10;++i){
			llNode.addToTail(i);
		}
		Runner = llNode;
		while(Runner!=null){
			System.out.print(Runner.data+",");
			Runner = Runner.next;	
		}
		System.out.println();
	
		GetKthToLast(llNode);

	}
}