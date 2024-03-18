package traccia2021;

import java.io.*;
import java.util.*;

public class Roulette {

    private Map<Integer,Integer> adiacenze[] = new TreeMap[37];
    private Set<Integer> usciti = new TreeSet<>();

    public Roulette ( File f ) throws IOException {

        if (!f.exists()) throw new RuntimeException("Il file non esiste");
        BufferedReader bf = new BufferedReader(new FileReader(f));
        String regex = "([0-9]|[1-2]|[0-9]|3[0-6])";
        String schema = regex + "(\\s" + regex + ")*";
        String l;
        int x = -1;
        while (true) {
            l = bf.readLine();
            if (l == null) break;
            if (!l.matches(schema)) throw new RuntimeException("File Scorreggio");
            StringTokenizer st = new StringTokenizer(l, " ");
            x = -1;
            while (st.hasMoreTokens()) {
                int y = Integer.parseInt(st.nextToken());
                usciti.add(y);
                if( x!= -1 ){
                    if (adiacenze[x] == null )
                        adiacenze[x] = new TreeMap<>();
                    if ( !adiacenze[x].containsKey(y) )
                        adiacenze[x].put(y,0);
                    adiacenze[x].put(y,adiacenze[x].get(y)+1);

                }
                x=y;
            }
        }
        bf.close();
    }

    public int numeroPiuFrequenteDopo ( int x ) {
        if(!uscito(x)) throw new RuntimeException("L'elemento "+x+" non è mai uscito ");

        Map<Integer,Integer> a = adiacenze[x];
        int m=0;
        int key=-1;
        for( int y : a.keySet() ){
            if( a.get(y)> m ) {
                m = a.get(y);
                key = y ;
            }
        }

        return key;
    }

    boolean uscito (int x){ return usciti.contains(x); }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Metti il nome del file");
        String nome = sc.nextLine();

        File f = new File(nome);
        Roulette r = new Roulette(f);





    }
}
