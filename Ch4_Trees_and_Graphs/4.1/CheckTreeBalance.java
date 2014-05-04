import java.util.Random;

public class CheckTreeBalance{


	public static boolean isBalanced(TreeNode root){
		if(root==null)
			return true;
		if(!isBalanced(root.left)||!isBalanced(root.right)){
			return false;
		}
		else if(Math.abs(getHeight(root.left)-getHeight(root.right))>1){
			return false;
		}
		return true;
	}

	public static int getHeight(TreeNode root){
		int height=0;
		if(root==null)
			return height;
		height = Math.max(getHeight(root.left), getHeight(root.right))+1;
		return height;
	}

	public static void main(String[] args){
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		System.out.println("Root? " + root.data);
		System.out.println("Is balanced? " + isBalanced(root));
		
		// Could be balanced, actually, but it's very unlikely...
		TreeNode unbalanced = new TreeNode(10);
		Random rdgenerator = new Random();
		for (int i = 0; i < 10; i++) {
			unbalanced.insertInOrder(rdgenerator.nextInt(100));
		}
		System.out.println("Root? " + unbalanced.data);
		System.out.println("Is balanced? " + isBalanced(unbalanced));
	}
}