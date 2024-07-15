package Tinkoff1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        printPyramid((int) (2*Math.pow(10,5)));
    }
    private static void printPyramid(int n){
        System.out.println(n);
        List<Long> values = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            Long cube = (long) Math.pow(2*i -1, 3);
            Long pyramid = (long) ((i*(4*Math.pow(i,2) -1))/3);
            values.add(cube - pyramid);
        }
        System.out.println(values.stream().map(Objects::toString).collect(Collectors.joining(" ")));
    }
}
