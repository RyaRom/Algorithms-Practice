package YandexHandbookAlg;

import java.util.*;
import java.util.stream.Collectors;

public class Task6_4_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Node> segments = new ArrayList<>();
        List<Integer> dots = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            segments.add(new Node(sc.nextInt(), sc.nextInt()));
        }
        segments.sort(Comparator.comparingInt(Node::getRight));
        for (int i = 0; i < segments.size();) {
            int right = segments.get(i).getRight();
            dots.add(right);
            if (i>=segments.size()-1) {
                break;
            }
            while (i < segments.size() && segments.get(i).getLeft() <= right) {
                i++;
            }
        }
        System.out.println(dots.size());
        System.out.println(dots.stream().map(Objects::toString).collect(Collectors.joining(" ")));

    }
    private static class Node{
        private int left;
        private int right;

        public int getLeft() {
            return left;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public int getRight() {
            return right;
        }

        public void setRight(int right) {
            this.right = right;
        }

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
