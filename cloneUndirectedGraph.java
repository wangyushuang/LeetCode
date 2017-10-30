/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
//1.利用HashMap存储已经复制过的结点
//2.利用DFS和递归实现
import java.util.ArrayList;
import java.util.HashMap;
public class cloneUndirectedGraph {
    HashMap<Integer,UndirectedGraphNode> map=new HashMap<Integer,UndirectedGraphNode>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null)
            return null;
        if(map.containsKey(node.label))
            return map.get(node.label);
        UndirectedGraphNode nNode=new UndirectedGraphNode(node.label);
        map.put(nNode.label,nNode);
        for(int i=0;i<node.neighbors.size();i++){
            nNode.neighbors.add(cloneGraph(node.neighbors.get(i)));
        }
        return nNode;
    }
}