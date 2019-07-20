//We use two queues because we are not doing BFS, we are doing level order traversal. 
//Think about how bfs is different from level order
public BinaryTreeNodesInOrderOfIncreasingDepth{
	public static List<List<Integer>> binaryTreeDepthOrder(
		BinaryTreeNode<Integer> tree){

		Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
		List<List<Integer>> result = new ArrayList<>();

		while(!q.isEmpty()){
			Queue<BinaryTreeNode<Integer>> nextDepthNodes = new LinkedList<>();
			List<Integer> thisLevel = new ArrayList<>();
			while(!q.isEmpty()){
				BinaryTreeNode<Integer> curr = q.poll();
				if(curr != null){
					thisLevel.add(curr.data);
				}
				nextDepthNodes.add(curr.left);
				nextDepthNodes.add(curr.right);
			}

		}

		if(!thisLevel.isEmpty()){
			result.add(thisLevel);
		}
		q = nextDepthNodes;
	}
	return result

}

class BinaryTreeNode{
	Integer data;
	BinaryTreeNode left;
	BinaryTreeNode right;

	public BinaryTreeNode(Integer data){
		this.data = data;
	}
}