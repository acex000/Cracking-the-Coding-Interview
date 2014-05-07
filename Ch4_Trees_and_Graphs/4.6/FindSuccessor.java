public class FindSuccessor{

	public static BinaryTreeNode<Integer> getStartNode(BinaryTreeNode<Integer> root, int number){
		while(root!=null){
			if(number<root.data)
				root = root.leftChild;
			else if(number>root.data)
				root = root.rightChild;
			else
				return root;
		}

		return root;
	}

	public static BinaryTreeNode<Integer> findSuccessor(BinaryTreeNode<Integer> root){
		if(root.rightChild!=null){
			return findMin(root.rightChild);
		}

		while(root.parent!=null&&root==root.parent.rightChild){
			root = root.parent;
		}

		return root.parent;
	}
		


	public static BinaryTreeNode<Integer> findMin(BinaryTreeNode<Integer> root){
		if(root.leftChild==null){
			return root;
		}
		else{
			return findMin(root.leftChild);
		}
	}

	public static void main(String[] args){
		Integer[] arr = {1,2,3,4,5,6,7,8,9};
		BinaryTreeNode<Integer> root = BinaryTreeNode.createMinimalBSTree(arr);
		int startNumber = 7;
		BinaryTreeNode<Integer> startNode = getStartNode(root,startNumber);
		BinaryTreeNode<Integer> successorNode =  findSuccessor(startNode);

		for(Integer i: arr){
			System.out.print(i+",");
		}
		System.out.println();
		System.out.println("start number: "+startNumber);
		System.out.println("successorNode number: "+successorNode.data);
	}

}


