package Appello12cfu;

import java.util.Arrays;

public class prove {
    public static void main(String[] args) {
        int[] a = {2,3,5,6};
        int[] b = {3,5,6,7};
        System.out.println(contiene(a,b));
    }

    static boolean contiene(int[] a, int[] b){
        for (int i = 0; i < a.length; i++){
            int curr = a[i];
            for (int j = 0; j < b.length; j++) {
                if(curr == a[i])
                    break;
                if(curr != a[i] && j == b.length-1)
                    return false;

            }
        }
        return true;
    }
}
