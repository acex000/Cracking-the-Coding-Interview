//Used LinkedList class to solve this question.
import java.util.LinkedList;

public class KthNodeToLast{


	public static void GetKthToLast(LinkedList ll, int kth){
		int size = ll.size();
		int result;
		result = (Integer)ll.get(size-kth);
		System.out.println(kth+"th to last element is "+result);
	}

	public static void main(String[] args){
		LinkedList ll = new LinkedList();
		int kth = 3;
		for(int i=0;i<10;++i){
			ll.add(i);
		}
		System.out.println(ll);

		GetKthToLast(ll,kth);

	}
}