package BinaryTreeChildDFS;

import java.util.HashMap;
import java.util.HashSet;

class Solution {
    private final HashMap<TreeNode, TreeNode> parents = new HashMap<>();
    private int counter = 0;
    public int countPairs(TreeNode root, int distance) {
        DFC(root,distance);
        return counter/2;
    }
    private void DFC(TreeNode current, int distance){
        if (isLeaf(current)){
            HashSet<TreeNode> checked = new HashSet<>();
            DFCFromLeaf(current, distance, checked);
            counter--;
        }
        else {
            if (current.left != null) {
                parents.put(current.left, current);
                DFC(current.left,distance);
            }
            if (current.right != null) {
                parents.put(current.right, current);
                DFC(current.right,distance);
            }
        }
    }
    private void DFCFromLeaf(TreeNode current, int distance, HashSet<TreeNode> checked){
        if (distance<0)return;
        if (isLeaf(current)) counter++;
        checked.add(current);
        if (current.right!= null && !checked.contains(current.right)){
            DFCFromLeaf(current.right, distance-1, checked);
        }if (current.left!= null && !checked.contains(current.left)){
            DFCFromLeaf(current.left, distance-1, checked);
        }
        TreeNode parent = parents.get(current);
        if (parent!= null && !checked.contains(parent)){
            DFCFromLeaf(parent, distance-1, checked);
        }
    }
    private boolean isLeaf(TreeNode treeNode) {
        return treeNode.left == null && treeNode.right==null;
    }
}