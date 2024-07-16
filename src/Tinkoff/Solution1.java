package Tinkoff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution1 {
    private static final BufferedReader fastScanner = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        fastScanner.readLine();
        if (Arrays.stream(fastScanner.readLine().split(" ")).mapToLong(Long::parseLong).sum() %2 == 0)
            System.out.println("YES");
        else System.out.println("NO");
    }
}
