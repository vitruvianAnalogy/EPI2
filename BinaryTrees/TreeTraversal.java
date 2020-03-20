//Time complexity of each approach is O(n) because we visit each node
//Space complexity is what the recursive stack uses and is O(h) where h is the depth
// h can vary from 'log n' (complete binary tree) to 'n' (for a skewed tree)
public class TreeTraversal{
	public static void preorder(BinaryTreeNode<Integer> root){
		if(root != null){
			//root - left - right
			System.out.println(root.data);
			preorder(root.left);
			preorder(root.right);
		}
	}

	public static void postorder(BinaryTreeNode<Integer> root){
		if(root != null){
			//left - right - root
			postorder(root.left);
			postorder(root.right);
			System.out.println(root.data);
		}
	}

	public static void inorder(BinaryTreeNode<Integer> root){
		if(root != null){
			//left - root - right
			inorder(root.left);
			System.out.println(root.data);
			inorder(root.right);
		}
	}
}