package PassangerFilter;

import java.util.Arrays;

class Solution {
    public int countSeniors(String[] details) {
        return (int) Arrays.stream(details).filter(detail->Integer.parseInt("" + detail.charAt(11) + detail.charAt(12))>=60).count();
    }
}