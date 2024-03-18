package SpellingChecker;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;

import static SpellingChecker.Similarita.*;

public class SpellingChecker {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Infila il numero parole nel dizionario");
//        ArrayList<String> a = new ArrayList<>(sc.nextInt());

        Set<String> Dizionario = new HashSet<>();

        //System.out.println("Infila il path del dizionario");
        //File f = new File(sc.nextLine());
        File f1 = new File("C:\\Users\\umber\\Desktop\\Dizionari.txt");
        Scanner s1 = new Scanner(f1);

        while( s1.hasNext() ) {
            StringTokenizer st1 = new StringTokenizer(s1.nextLine());
            while (st1.hasMoreTokens()) {
                Dizionario.add(st1.nextToken().toLowerCase());
            }
        }
        System.out.println(Dizionario);

        Map<String,String> m = new HashMap<>();
        s1.close();

        File f = new File("C:\\Users\\umber\\Desktop\\Testo.txt");
        Scanner s = new Scanner(f);
        while ( s.hasNext() ) {
            StringTokenizer st = new StringTokenizer(s.nextLine());
            while(st.hasMoreTokens()) {
                String sostituto = null;
                int min = Integer.MAX_VALUE;
                String act = st.nextToken();
                for (String d : Dizionario) {
                    int distanza = lev(d, act);
                    if (distanza <= min) {
                        min = distanza;
                        sostituto = d;
                    }
                }
                m.put(act, sostituto);
            }
        }
        s.close();
        System.out.println(m);
    }
}
