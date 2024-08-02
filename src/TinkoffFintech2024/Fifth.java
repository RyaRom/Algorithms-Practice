package TinkoffFintech2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Fifth {
    private static final BufferedReader fastScan = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(fastScan.readLine());
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        int[] edges = new int[n];

        String[] buggedScanner = new String[n];
        for (int i = 0; i < n; i++) {
            buggedScanner[i] = fastScan.readLine();
        }

        Queue<Integer> toDelete = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int [] node = Arrays.stream(buggedScanner[i].split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 1; j <= node[0]; j++) {
                node[j]--;
                edges[i]++;
                if (graph.containsKey(node[j])) graph.get(node[j]).add(i);
                else graph.put(node[j], new ArrayList<>(List.of(i)));
            }
            if (edges[i]==0)toDelete.add(i);
        }

        List<List<Integer>> operations = new ArrayList<>();

        while (!toDelete.isEmpty()) {
            ArrayList<Integer> deletion = new ArrayList<>();
            for (int td:toDelete){
                deletion.add(td+1);
            }
            Collections.sort(deletion);
            deletion.addFirst(toDelete.size());
            operations.add(deletion);
            Queue<Integer> buffer = new LinkedList<>();
            while (!toDelete.isEmpty()){
                int vertexToDelete = toDelete.poll();
                if (graph.containsKey(vertexToDelete)) {
                    ArrayList<Integer> todel = graph.get(vertexToDelete);
                    for (int child : todel) {
                        edges[child]--;
                        if (edges[child] == 0) buffer.add(child);
                    }
                }
            }
            toDelete.addAll(buffer);
        }

        System.out.println(operations.size());
        for (List<Integer> operation : operations) {
            System.out.println(operation.stream().map(Objects::toString).collect(Collectors.joining(" ")));
        }
    }
}
