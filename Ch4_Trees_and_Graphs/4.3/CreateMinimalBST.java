public class CreateMinimalBST{


	public static void inOrderPrintTree(BinaryTreeNode<Integer> root){
		if(root!=null){
			inOrderPrintTree(root.leftChild);
			System.out.print(root.data+",");
			inOrderPrintTree(root.rightChild);
		}
	}

	public static void main(String[] args){
		Integer[] arr = {1,2,3,4,5,6,7};
		BinaryTreeNode<Integer> root = BinaryTreeNode.createMinimalBSTree(arr);
		inOrderPrintTree(root);
		System.out.println();
	}
}