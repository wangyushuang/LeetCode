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
public class preOrderTraversal {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        if(root==null)
            return result;
        result.add(root.val);
        ArrayList<Integer> tmp;
        if(root.left!=null){
            tmp=preorderTraversal(root.left);
            for(int i=0;i<tmp.size();i++)
                result.add(tmp.get(i));
        }
        if(root.right!=null){
            tmp=preorderTraversal(root.right);
            for(int i=0;i<tmp.size();i++)
                result.add(tmp.get(i));
        }
        return result;
    }
}
