package contests.tinkoffFintech2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fourth {
    private static final BufferedReader fastScan = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(fastScan.readLine());
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[n];

        String[] inputs = new String[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = fastScan.readLine();
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String[] parts = inputs[i].split(" ");
            int dependencies = Integer.parseInt(parts[0]);
            for (int j = 1; j <= dependencies; j++) {
                int dependency = Integer.parseInt(parts[j]) - 1;
                graph.computeIfAbsent(dependency, k -> new ArrayList<>()).add(i);
                inDegree[i]++;
            }
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                int process = queue.poll();
                currentLevel.add(process + 1);
                if (graph.containsKey(process)) {
                    for (int neighbor : graph.get(process)) {
                        inDegree[neighbor]--;
                        if (inDegree[neighbor] == 0) {
                            queue.add(neighbor);
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}