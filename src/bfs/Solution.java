package bfs;

import java.util.*;

class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> adj = new ArrayList<>(edges.length);
        for (int i = 0; i < 10000; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int f = edge[0];
            int s = edge[1];
            adj.get(f).add(s);
            adj.get(s).add(f);
        }
        int[] firstShortest = new int[adj.size()];
        int[] secondShortest = new int[adj.size()];
        Arrays.fill(firstShortest, -1);
        Arrays.fill(secondShortest, -1);
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{1,1});
        firstShortest[1]=0;
        while (!queue.isEmpty()){
            int[] neighbours = queue.poll();
            int x = neighbours[0];
            int visited = neighbours[1];
            int t = visited==1?firstShortest[x] :secondShortest[x];

            if (t/change%2==1) t= change * (t/change) + time;
            else  t+=time;

            for (int v : adj.get(x)) {
                if (firstShortest[v]==-1){
                    firstShortest[v]=t;
                    queue.add(new int[]{v,1});
                }
                else if (secondShortest[v]==-1&&firstShortest[v]!=t){
                    if (v==n)return t;
                    secondShortest[v]=t;
                    queue.add(new int[]{v,2});
                }
            }
        }
        return 0;
    }
}
