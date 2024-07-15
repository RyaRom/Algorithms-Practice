package BinaryTree;


import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().createBinaryTree(new int[][]{{1,2,1},{2,3,0},{3,4,1}}));
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode> nodes = new HashMap<>();
        HashSet<Integer> hasParents = new HashSet<>();
        for (int[] node: descriptions){
            int val = node[0];
            int child = node[1];
            boolean isRight = node[2] == 0;
            hasParents.add(child);
            getOrCreateNode(val, child, isRight, nodes);
        }
        TreeNode orphan = new TreeNode();
        for (int node : nodes.keySet()){
            if (!hasParents.contains(node)) {
                orphan = nodes.get(node);
            }
        }
        return orphan;
    }
    private TreeNode getOrCreateNode(int val, int child, boolean isRight, HashMap<Integer, TreeNode> nodes){
        if (!nodes.containsKey(val)){
            TreeNode node = new TreeNode(val);
            if (child != -1) {
                if (isRight) node.right = getOrCreateNode(child, -1, true, nodes);
                else node.left = getOrCreateNode(child, -1, false, nodes);
            }
            nodes.put(val, node);
            return node;
        }else {
            TreeNode node = nodes.get(val);
            if (child != -1) {
                if (isRight) node.right = getOrCreateNode(child, -1, true, nodes);
                else node.left = getOrCreateNode(child, -1, false, nodes);
            }
            return node;
        }
    }
}