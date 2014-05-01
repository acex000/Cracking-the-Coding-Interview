public class MyQueueApp{

	public static void main(String[] args){
		MyQueue<Integer> myQ = new MyQueue<Integer>();

		for(int i=1;i<6;++i){
			myQ.enQueue(i);
		}

		while(!myQ.isEmpty()){
			System.out.print(myQ.deQueue()+",");
		}
		System.out.println();
	}
}