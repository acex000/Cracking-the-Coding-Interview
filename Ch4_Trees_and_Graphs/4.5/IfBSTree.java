public class IfBSTree{

	public static Result isBSTree(BinaryTreeNode<Integer> root){
		if(root!=null){
			Result leftResult;
			Result rightResult;
			if(root.leftChild!=null){
				leftResult = isBSTree(root.leftChild);
			}
			else{
				leftResult = new Result(Integer.MIN_VALUE, true);
			}
			if(root.rightChild!=null){
				rightResult = isBSTree(root.rightChild);
			}
			else{
				rightResult = new Result(Integer.MAX_VALUE, true);
			}
			if(leftResult.isBSTree&&rightResult.isBSTree&&leftResult.value<root.data&&root.data<=rightResult.value)
				return new Result(root.data, true);
			else
				return new Result(root.data, false);
		}
		return null;
	}

	public static void main(String[] args){
		//create a BST
		Integer[] arr1 = {1,2,3,4,5,6};
		BinaryTreeNode<Integer> rootOfBST = BinaryTreeNode.createMinimalBSTree(arr1);
		Result result1 = isBSTree(rootOfBST);
		System.out.println(result1.isBSTree);

		//create a binary tree, but not a search tree
		Integer[] arr2 = {3,2,5,1,9,7};
		BinaryTreeNode<Integer> rootOfNonBST = new BinaryTreeNode<Integer>(arr2[0]);
		BinaryTreeNode<Integer> temp = rootOfNonBST;
		for(int i =1;i<arr2.length;++i){
			temp.setRightChild(new BinaryTreeNode<Integer>(arr2[i]));
			temp = temp.rightChild;
		}
		Result result2 = isBSTree(rootOfNonBST);
		System.out.println(result2.isBSTree);
	}

	//use result class to contains both the number value of current node and the BST judgement boolean value of its subtree 
	public static class Result{
		private int value;
		private boolean isBSTree;
		public Result(int value, boolean isBSTree){
			this.value = value;
			this.isBSTree = isBSTree;
		}
	}
}