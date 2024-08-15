package kahnAlgorithmTopologicalSort;


import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().buildMatrix(3, new int[][]{{1, 2}, {2,3},{3,1},{2,3}}, new int[][]{{2, 1}})));
    }
    private static class Pair{
        Integer before;
        Integer after;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return Objects.equals(before, pair.before) && Objects.equals(after, pair.after);
        }

        @Override
        public int hashCode() {
            return Objects.hash(before, after);
        }

        public Integer getAfter() {
            return after;
        }

        public void setAfter(Integer after) {
            this.after = after;
        }

        public Integer getBefore() {
            return before;
        }

        public void setBefore(Integer before) {
            this.before = before;
        }

        public Pair(Integer after, Integer before) {
            this.after = after;
            this.before = before;
        }
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int [][] matrix = new int[k][k];
        List<Integer> orderedRows = topologicalSort(k, rowConditions);
        List<Integer> orderedCols = topologicalSort(k, colConditions);
        if (orderedRows == null || orderedCols == null) return new int[][]{};
        for (int i = 0; i < k; i++) {
            int n =orderedRows.get(i);
            matrix[i][orderedCols.indexOf(n)] = n;
        }
        return matrix;
    }
    private List<Integer> topologicalSort(int k, int[][] graph){
        List<Integer> res = new ArrayList<>();
        LinkedHashSet<Integer> sorted = new LinkedHashSet<>();
        Stack<Integer> toNotDelete = new Stack<>();
//        HashMap<Integer, Integer> value = new HashMap<>();
        List<Pair> nodes = new ArrayList<>(Arrays.stream(graph).map(p->new Pair(p[0], p[1])).toList());
        for (Pair pair:nodes){
            toNotDelete.push(pair.after);
        }

        while (!nodes.isEmpty()) {
            boolean error = true;
            for (int i = 0; i<nodes.size();i++){
                Pair pair = nodes.get(i);
                if (!toNotDelete.contains(pair.before)){
                    nodes.remove(pair);
                    sorted.add(pair.before);
                    error = false;
                }
            }
            if (error)return null;
            toNotDelete.clear();
            for (Pair pair:nodes){
                toNotDelete.push(pair.after);
            }
        }
        for (int i = 0; i < sorted.size(); i++) {
            res.add(sorted.getFirst());
            sorted.removeFirst();
        }
        for (int i = 1; i <= k; i++) {
            if (!res.contains(i))res.add(i);
        }
        Collections.reverse(res);
        return res;
    }
}