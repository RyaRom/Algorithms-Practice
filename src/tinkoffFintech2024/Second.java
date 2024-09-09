package tinkoffFintech2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Second {
    private static final BufferedReader fastScan = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        long a = Long.parseLong(fastScan.readLine());
        if (a==1) System.out.println(1);
        else if (a==0) System.out.println(0);
        else System.out.println(4*(a-1));
    }
}
