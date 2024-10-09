package contests.tinkoffFintech2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class First {
    private static final BufferedReader fastScan = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        long a = Long.parseLong(fastScan.readLine());
        BigInteger num = new BigInteger(String.valueOf(a));
        BigInteger firs = num.multiply(BigInteger.valueOf(a + 1)).divide(new BigInteger("2"));
        int b = (99 * 100) / 2;
        BigInteger second = new BigInteger(String.valueOf(b));
        System.out.println(firs.add(second.negate()));
    }
}