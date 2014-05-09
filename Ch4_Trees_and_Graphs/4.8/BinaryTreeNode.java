//normally, generics type T cannot be compared with each other. In order to pass the compiling by comparing data in insertInOrder() method,
//we used interface Comparable<T>.
public class BinaryTreeNode<T extends Comparable<T>>{
	public BinaryTreeNode<T> parent=null;
	public BinaryTreeNode<T> leftChild=null;
	public BinaryTreeNode<T> rightChild=null;
	public T data;
	private int size;

	public BinaryTreeNode(T data){
		this.data = data;
		size = 1;
	}

	public void setLeftChild(BinaryTreeNode<T> leftChild){
		this.leftChild = leftChild;
		if(leftChild!=null){
			leftChild.parent = this;
		}
	}

	public void setRightChild(BinaryTreeNode<T> rightChild){
		this.rightChild = rightChild;
		if(rightChild!=null){
			rightChild.parent = this;
		}
	}
	
	public void insertInOrder(T newData){
		if(newData.compareTo(data)<=0){	//after using interface Comparable<T>, we use x.comparaTo(y) method of this interface to do the comparation
			if(this.leftChild==null){
				this.setLeftChild(new BinaryTreeNode<T>(newData));
			}
			else{
				this.leftChild.insertInOrder(newData);
			}
		}
		else if(newData.compareTo(data)>0){ //after using interface Comparable<T>, we use x.comparaTo(y) method of this interface to do the comparation
			if(this.rightChild==null){
				this.setRightChild(new BinaryTreeNode<T>(newData));
			}
			else{
				this.rightChild.insertInOrder(newData);	
			}
		}
		++size;
	}

	public static <T extends Comparable<T>> BinaryTreeNode<T> createMinimalBSTree(T[] array, int startIndex, int endIndex){
		int midIndex = (startIndex+endIndex)/2;
		BinaryTreeNode<T> root = new BinaryTreeNode<T>(array[midIndex]);
		if(endIndex<startIndex){
			return null;
		}
		//when call static method of a generics class, just use the name;e.g. here we use BinaryTreeNode.createMinimalTree(), 
		//rather than BinaryTreeNode<T>.createMinimalBSTree()
		root.setLeftChild(BinaryTreeNode.createMinimalBSTree(array, startIndex, midIndex-1));
		root.setRightChild(BinaryTreeNode.createMinimalBSTree(array, midIndex+1, endIndex));	
		return root;
		
		
		
	}

	public static <T extends Comparable<T>> BinaryTreeNode<T> createMinimalBSTree(T[] array){
		return createMinimalBSTree(array, 0, array.length-1);
	}

}