package Statistica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class StatisticaImpl extends StatisticaAstratta{

    TreeMap<String,Integer> inf = new TreeMap<>();

    public static void main(String[] args) throws FileNotFoundException {

        StatisticaImpl st = new StatisticaImpl();
        System.out.println(st);
        System.out.println(st.frequenza("Java"));
        System.out.println(st.mediana());
        System.out.println(st.moda());

    }

    public StatisticaImpl() throws FileNotFoundException {
        File f = new File("C:\\Users\\umber\\Desktop\\Telefono.txt");
        Scanner sc = new Scanner(f);

        while(sc.hasNext())
            arrivo(sc.next());

    }

    @Override
    public String toString() {
        return inf.toString();
    }

    @Override
    public void arrivo(String p) {

        p.strip();

        if( inf.containsKey(p) ){
            inf.put(p,inf.get(p)+1);
        }
        else {
            inf.put(p,1);
        }

    }

    @Override
    public int frequenza(String p) {
        return inf.get(p);
    }

    @Override
    public String moda() {

        String ris = null;
        int max = Integer.MIN_VALUE;
        for (String s : inf.keySet() ){
            if(inf.get(s)>max){
                ris = s;
                max = inf.get(s);
            }
        }
        return ris;

    }

    @Override
    public String mediana() {
        int i = inf.keySet().size()/2;
        for( String s: inf.keySet() ){
            if(i == 0 ) return s;
            i--;
        }
        return null;
    }

    @Override
    public Iterator<String> iterator() {
        return new StatsIterator<>();
    }

    protected class StatsIterator<T> implements Iterator<String> {

        Iterator<String> it = inf.keySet().iterator();
        String cur ;

        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        @Override
        public String next() {
            cur = it.next();
            return cur;
        }

    }
}
