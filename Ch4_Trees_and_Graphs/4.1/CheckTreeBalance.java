import java.util.Random;

public class CheckTreeBalance{


	public static boolean isBalanced(BinaryTreeNode root){
		if(root==null)
			return true;
		if(!isBalanced(root.leftChild)||!isBalanced(root.rightChild)){
			return false;
		}
		else if(Math.abs(getHeight(root.leftChild)-getHeight(root.rightChild))>1){
			return false;
		}
		return true;
	}

	public static int getHeight(BinaryTreeNode root){
		int height=0;
		if(root==null)
			return height;
		height = Math.max(getHeight(root.leftChild), getHeight(root.rightChild))+1;
		return height;
	}

	public static void main(String[] args){
		Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		BinaryTreeNode<Integer> root = BinaryTreeNode.createMinimalBSTree(array);
		System.out.println("Root? " + root.data);
		System.out.println("Is balanced? " + isBalanced(root));
		
		// Could be balanced, actually, but it's very unlikely...
		BinaryTreeNode<Integer> unbalanced = new BinaryTreeNode<Integer>(10);
		Random rdgenerator = new Random();
		for (int i = 0; i < 10; i++) {
			unbalanced.insertInOrder(rdgenerator.nextInt(100));
		}
		System.out.println("Root? " + unbalanced.data);
		System.out.println("Is balanced? " + isBalanced(unbalanced));
	}
}