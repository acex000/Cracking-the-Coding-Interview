public class Tower{

	MyStack<Integer> diskPivot;

	public Tower(){
		diskPivot = new MyStack<Integer>();
	}

	public void add(Integer newItem){
		if(!diskPivot.isEmpty()&&(diskPivot.peek()<=newItem)){
			System.out.println("Error, new disk is bigger than the top disk");
		}
		else{
			diskPivot.push(newItem);
		}
	}

	public void batchMoveTo(Integer n, Tower bufferT2, Tower destinationT3){
		if(n>0){
			
			this.batchMoveTo(n-1, destinationT3, bufferT2);
			this.topDiskTo(destinationT3);
			bufferT2.batchMoveTo(n-1, this, destinationT3);	
		}

	}

	public void topDiskTo(Tower targetT){
		// System.out.println("1;");
		// System.out.print(diskPivot.peek());
		int topDisk = diskPivot.pop();
		targetT.add(topDisk);
	}

	public void  printTower(){
		LinkedListNode<Integer> temp = diskPivot.getTopNode();
		while(temp!=null){
			System.out.print(temp.data);
			temp=temp.next;
		}
		System.out.println();
	}
}