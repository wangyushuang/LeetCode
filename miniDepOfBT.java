/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//思路：
//      1.用递归求二叉树的最低深度
//      2.有叶子结点时，必须包含叶子结点
public class miniDepOfBT {
    public int run(TreeNode root) 
    {
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)//该结点就是叶子结点
            return 1;
        if(root.left==null)//右子树有叶子结点
            return 1+run(root.right);
        if(root.right==null)
            return 1+run(root.left);//左子树有叶子结点
        return (run(root.left)<=run(root.right)?(run(root.left)+1):(run(root.right)+1));
    }
}