public class FirstAncestor{

	public static BinaryTreeNode<Integer> getNode(BinaryTreeNode<Integer> root, Integer value){
		
		if(root.data==value)
			return root;
		else if(value<root.data)
			return getNode(root.leftChild, value);
		else
			return getNode(root.rightChild, value);
	}

	public static Result findResult(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node1, BinaryTreeNode<Integer> node2){
		if(root==null){
			return new Result(null, false);
		}
		if(root==node1&&root==node2){
			return  new Result(root, true);
		}

		Result resultL = findResult(root.leftChild, node1, node2);
		if(resultL.isCommonAncestor)
			return resultL;
		Result resultR = findResult(root.rightChild, node1, node2);
		if(resultR.isCommonAncestor)
			return resultR;

		if(resultL.node!=null&&resultR.node!=null){		//A.:One is on leftsubtree ,the other one is on right subtree, so root will be the commonAncestor
			return new Result(root, true);
		}
		else if(root==node1||root==node2){ 				//B.:One node is found in left or right subtree,or no node is found in both sub tree
														//   Then we check if current root is node1 or node2, or current node may be just a normal node
														//   If current root is node1/node2, it means we found one node, and we have to return this node(current root) in result
			Boolean alreadyfoundOneNode = (resultL.node!=null||resultR.node!=null)?true:false; //Now we need to check if we found  another node in subtrees of current root,
																							//if we already found another node in the one sub tree of current root, 
																							//then current root is commonAncestor
			return new Result(root, alreadyfoundOneNode);			
		}
		else{											//C.:No mater we already found one node in subtrees or not, current node cannot be commonAncestor
														//   Thus, we need go upward and return a false in result
			return resultL.node!=null?resultL:resultR;		//Here if we already found a node in sub trees, either left or right, we will return the node.
															//Or we havnt found node1/node2 in both sub trees, we will return null node in result automatically			
		}
	}

	public static BinaryTreeNode<Integer> findCommonAncestor(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node1, BinaryTreeNode<Integer> node2){
		Result result = findResult(root, node1, node2);
		if(result.isCommonAncestor)
			return result.node;
		return null;
	}

	public static void main(String[] args){
		Integer[] arr = {1,2,3,4,5,6,7};
		BinaryTreeNode<Integer> root = BinaryTreeNode.createMinimalBSTree(arr);
		int node1Value = 2;
		int node2Value = 6;
		BinaryTreeNode<Integer> node1 = getNode(root, node1Value);
		BinaryTreeNode<Integer> node2 = getNode(root, node2Value);

		BinaryTreeNode<Integer> commonAncestor = findCommonAncestor(root, node1, node2);

		System.out.println(commonAncestor.data);
	}
	
	public static class Result{
		private BinaryTreeNode<Integer> node;
		private boolean isCommonAncestor;

		public Result(BinaryTreeNode<Integer> node, boolean isCommonAncestor){
			this.node = node;
			this.isCommonAncestor = isCommonAncestor;
		}
	}



}