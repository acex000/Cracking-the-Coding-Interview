public class StackM{

	LinkedListNode<Integer> top=null;
	// LinkedListNode min;
	int depth=0;
	LinkedListNode<LinkedListNode<Integer>> minListTop=null;

	public void push(Integer object){
		LinkedListNode<Integer> newItem = new LinkedListNode<Integer>(object);
		newItem.next = top;
		top = newItem;
		++depth;
		if(minListTop==null){
			LinkedListNode<LinkedListNode<Integer>> min = new LinkedListNode<LinkedListNode<Integer>>(top);
			minListTop = min;
		}
		else{
			LinkedListNode<Integer>  minNodeAddress = top.data>minListTop.data.data?minListTop.data:top;
			LinkedListNode<LinkedListNode<Integer>> min = new LinkedListNode<LinkedListNode<Integer>>(minNodeAddress);
			min.next = minListTop;
			minListTop = min;
		}
	}

	public Integer pop(){
		LinkedListNode<Integer> item = top;
		top = top.next;
		minListTop = minListTop.next;
		--depth;
		return item.data;
	}

	public Integer getMin(){
		return minListTop.data.data;
	}

	public int getDepth(){
		return	depth;
	}

	public boolean isEmpty(){
		if(depth==0)
			return true;
		else
			return false;
	}

	public Integer peek(){
		return top.data;
	}
}