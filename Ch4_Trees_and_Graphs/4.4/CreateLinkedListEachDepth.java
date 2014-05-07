import java.util.LinkedList;
import java.util.Queue;

public class CreateLinkedListEachDepth{

	public static LinkedList<LinkedList<BinaryTreeNode<Integer>>> createLists(BinaryTreeNode<Integer> root){
		LinkedList<LinkedList<BinaryTreeNode<Integer>>> mainList = new LinkedList<LinkedList<BinaryTreeNode<Integer>>>();
		int depth=0;
		int numberOfNodesEachDepth=1;
		int count=0;
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
		if(root!=null){
			queue.offer(root);

			while(!queue.isEmpty()){
				BinaryTreeNode<Integer> tempTreeNode = queue.poll();

				//if count is 0, this means we are inserting the first node in a new depth
				if(count==0){
					LinkedList<BinaryTreeNode<Integer>> tempSubList = new LinkedList<BinaryTreeNode<Integer>>();
					tempSubList.add(tempTreeNode);
					mainList.add(tempSubList);
					++depth;
					++count;
					//for the root node, when insert the root node into the first list, the list is just full for the depth 1 level
					if(count==numberOfNodesEachDepth){
						count = 0;
						numberOfNodesEachDepth *=2;
					}
				}
				else {
					//if count >0 and < max number of node in this depth, then we just insert the node into the list of this depth
					if(count<numberOfNodesEachDepth){
						mainList.get(depth-1).add(tempTreeNode);//
						++count;
						// if the list of this depth is full, we reset count and get the max number of next level will be multiplied by 2
						if(count==numberOfNodesEachDepth){
							count = 0;
							numberOfNodesEachDepth *=2;
						}
					}
				}


				if(tempTreeNode.leftChild!=null)
					queue.offer(tempTreeNode.leftChild);
				if(tempTreeNode.rightChild!=null)
					queue.offer(tempTreeNode.rightChild);

			}
			return mainList;
		}
		
		return null;
	}

	public static void main(String[] agrs){
		Integer[] arr = {1,2,3,4,5};
		BinaryTreeNode<Integer> root = BinaryTreeNode.createMinimalBSTree(arr);
		LinkedList<LinkedList<BinaryTreeNode<Integer>>> listsSet = createLists(root);
		for(LinkedList<BinaryTreeNode<Integer>> subList : listsSet){
			for(BinaryTreeNode<Integer> node : subList){
				System.out.print(node.data+",");
			}
			System.out.println();
		}
	}
}