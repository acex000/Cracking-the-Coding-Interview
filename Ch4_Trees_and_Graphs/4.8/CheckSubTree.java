public class CheckSubTree{


	public static boolean checkSubTree(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2){
		if(root2 == null)
			return true;
		if(root1!=null){
			// System.out.print(root1.data);
			// System.out.print("("+root2.data+"),");
			if (root1.data==root2.data) {
				// System.out.println("yes?");
				return checkMatch(root2, root1);
				
			}
			boolean resultL = checkSubTree(root1.leftChild, root2);
			boolean resultR = checkSubTree(root1.rightChild, root2);
			return resultL||resultR;
		}
		return false;	
	}

	public static boolean checkMatch(BinaryTreeNode<Integer> root2, BinaryTreeNode<Integer> root1){
		if(root2!=null){
			if(root1==null)
				return false;
			if(root2.data==root1.data){
				boolean resultL = checkMatch(root2.leftChild, root1.leftChild);
				boolean resultR = checkMatch(root2.rightChild, root1.rightChild);
				return resultL&&resultR;
			}
			return false;
		}
		return true;
	}

	public static void main(String[] args){
		Integer[] arr1 = {1,2,3,4,5,6,7,8,9,10,11,12};
		Integer[] arr2 = {8,10,11,12};
		Integer[] arr3 = {10,11,12};
		BinaryTreeNode<Integer> root1 = BinaryTreeNode.createMinimalBSTree(arr1);
		BinaryTreeNode<Integer> root2 = BinaryTreeNode.createMinimalBSTree(arr2);
		BinaryTreeNode<Integer> root3 = BinaryTreeNode.createMinimalBSTree(arr3);

		boolean result1 = checkSubTree(root1, root2); 
		boolean result2 = checkSubTree(root1, root3); 
		System.out.println(result1);
		System.out.println(result2);
	}
}