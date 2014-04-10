import java.util.LinkedList;
import java.util.Hashtable;

public class RemoveDuplicates{

	public  static void RmDuplicates(LinkedList<Integer> ll){
		Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
		// ListIterator<Integer> li = ll.listIterator(0);
		for(int i=0;i<ll.size();++i){
			if(ht.contains(ll.get(i))){
				ll.remove(i);
				--i; //when a node is deleted, the current ll.get(i),will become the next element automatically, so --i to make it fall back 1 element
			}
			else{
				ht.put(ll.get(i), i);
			}
		}			
	}





	public static void  main(String[] args){

		LinkedList<Integer> ll = new LinkedList<Integer>();

		for(int i=0;i<6;++i){
			ll.add(i%3);
		}
		System.out.println(ll);

		RmDuplicates(ll);
		System.out.println(ll);
	}

}