package YandexHandbookAlg;

import java.util.Scanner;

public class Task5_1_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long index = sc.nextLong();
        int exp = sc.nextInt();
        if (index==0){
            System.out.println(0);
            return;
        }
        if (index==1){
            System.out.println(1);
            return;
        }
        int period = pianoPeriod(exp);
        int fibIndex = (int) (index%period);
        System.out.println(slowMod(fibIndex, exp));

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
