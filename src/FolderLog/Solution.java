package FolderLog;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(new String[]{"./","wz4/","../","mj2/","../","../","ik0/","il7/"}));
    }
    public int minOperations(String[] logs) {
        int currentDepth=0;
        for (String dir: logs){
            if  (dir.equals("../")) currentDepth = Math.max(0, currentDepth-1);
            else if (!dir.equals("./") && dir.matches(".*/")) currentDepth++;
        }
        return currentDepth;
    }
}