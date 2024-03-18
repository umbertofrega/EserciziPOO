package SpellingChecker;

import javax.print.CancelablePrintJob;
import java.util.LinkedList;
import java.util.Set;

import static java.util.Collections.min;

public class Similarita {

    static int lev(String a, String b) {
        if (a.length() == 0) return b.length();
        if (b.length() == 0) return a.length();
        if (a.charAt(0) == b.charAt(0)) return lev(a.substring(1), b.substring(1));

        return 1 + min(lev(a.substring(1), b),
                lev(a, b.substring(1)),
                lev(a.substring(1), b.substring(1)));

    }//lev

    private static int min(int ... a) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++)
            if(a[i]<min) min = a[i];

        return min;
    }

    public static void main(String[] args) {
        String a = "pizza";
        String b = "pizza";
        if( a == null || b == null ) throw new IllegalArgumentException();
        System.out.println(lev(a,b));
    }

}
