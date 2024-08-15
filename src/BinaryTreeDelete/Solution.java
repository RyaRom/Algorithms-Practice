package binaryTreeDelete;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        TreeNode n1=  new TreeNode(1);
        TreeNode n2=  new TreeNode(2);
        TreeNode n3=  new TreeNode(3);
        TreeNode n4=  new TreeNode(4);
        n1.right = n2;
        n1.left = n3;
        n3.right = n4;
        System.out.println(new Solution().delNodes(n1, new int[]{2,1}));
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> newRoots = new ArrayList<>();
        HashSet<Integer> toDelete = new HashSet<>(Arrays.stream(to_delete).boxed().toList());
        if (!toDelete.contains(root.val)) newRoots.add(root);
        else {
            if (root.left!=null)newRoots.add(root.left);
            if (root.right!=null)newRoots.add(root.right);
        }
        if (root.left!=null)DFC(true, root, root.left, newRoots, toDelete);
        if (root.right!=null)DFC(false, root, root.right, newRoots, toDelete);
        return newRoots;
    }
    private void DFC (boolean isLeft, TreeNode parent, TreeNode root, List<TreeNode> newRoots, HashSet<Integer> toDelete){
        if (toDelete.contains(root.val)){
            newRoots.remove(root);
            if (root.left!=null){
                newRoots.add(root.left);
                DFC(true, root, root.left, newRoots, toDelete);
            }
            if (root.right!=null){
                newRoots.add(root.right);
                DFC(false, root, root.right, newRoots, toDelete);
            }
            if (isLeft){
                parent.left = null;
            }else parent.right = null;
        }
        if (root.left!=null)DFC(true, root, root.left, newRoots, toDelete);
        if (root.right!=null)DFC(false, root, root.right, newRoots, toDelete);
    }
}
