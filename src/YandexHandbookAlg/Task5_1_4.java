package YandexHandbookAlg;

import java.util.Scanner;

public class Task5_1_4 {
    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        long n = s.nextLong();
        int lnFib = lastNumFib(n+2, 10)-1;
        System.out.println(lnFib == -1?9:lnFib);
    }

    private static int lastNumFib(long index, int exp){
        if (index==0){
            return 0;
        }
        if (index==1){
            return 1;
        }
        int period = pianoPeriod(exp);
        int fibIndex = (int) (index%period);
        return slowMod(fibIndex, exp);
    }


    private static int slowMod(int fibIndex, int fibExp){
        if (fibIndex==0) return 0;
        int curr = 0;
        int next = 1;
        for (int i = 2; i <= fibIndex; i++) {
            int oldNext = next;
            next = (oldNext + curr)%fibExp;
            curr = oldNext;
        }
        return next;
    }

    private static int pianoPeriod(int mod){
        int current = 0;
        int next = 1;
        int period = 0;
        while (true){
            int oldNext = next;
            next = (oldNext + current)%mod;
            current = oldNext;
            period++;
            if (current == 0 && next ==1 ) return period;
        }
    }
}
