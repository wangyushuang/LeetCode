/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.ArrayList;
public class postOrderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root==null)
            return result;
        ArrayList<Integer> tmp;
        if(root.left!=null){
            tmp=postorderTraversal(root.left);
            for(int i=0;i<tmp.size();i++)
                result.add(tmp.get(i));
        }
        if(root.right!=null){
            tmp=postorderTraversal(root.right);
            for(int i=0;i<tmp.size();i++)
                result.add(tmp.get(i));
        }
        result.add(root.val);
        return result;
    }
}