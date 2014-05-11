/*
In this question, we are only required to provide a monotonically increasing solution path. That means we dont need to think about
the condition that the solution path may swung up and down in the tree(its hard to solve, I think).
In the interview we need to ask interviewer to ensure this.
*/
public class PathEqualsSum{

	public static void findPath(BinaryTreeNode<Integer> root, int sum, int[] pathAccumulate, int currentDepth){
		if(root!=null){
			currentDepth++;
			
			pathAccumulate[currentDepth]=root.data;
			int currentSum=0;

			for(int i=currentDepth;i>=0;--i){
				currentSum+=pathAccumulate[i];
				if(currentSum==sum)
					printSubArray(pathAccumulate, i, currentDepth);
			}
			findPath(root.leftChild, sum, pathAccumulate, currentDepth);
			findPath(root.rightChild, sum, pathAccumulate, currentDepth);
		}
	}

	public static void findPath(BinaryTreeNode<Integer> root, int sum){
		int totalDepth = getDepth(root);
		
		int[] pathAccumulate = new int[totalDepth+1];
		int currentDepth = -1;
		
		findPath(root, sum, pathAccumulate, currentDepth);
	}

	public static int getDepth(BinaryTreeNode<Integer> root){
		if(root==null){
			return -1;
		}
		return 1+Math.max(getDepth(root.leftChild), getDepth(root.rightChild));
	}

	public static void printSubArray(int[] pathAccumulate, int start, int end){
		for(int i=start;i<=end;++i)
			System.out.print(pathAccumulate[i]+",");
		System.out.println();
	}

	public static void main(String[] agrs){
		Integer[] arr = {1,3,4,5,6,7,-3,-2,-1,-4};
		BinaryTreeNode<Integer> root = BinaryTreeNode.createMinimalBSTree(arr);
		int sum = 7;
		findPath(root, sum);
	}
}