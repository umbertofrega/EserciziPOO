package matrice_sparsa;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

public class MatriceSparsaImpl extends MatriceSparsaAbs{

    private Map<Integer, Map<Integer, Double>> ms = new HashMap<>();
    int n,m;
    public static void main(String[] args) {
        MatriceSparsa ms = new MatriceSparsaImpl(4,4);
        Random a = new Random();
        for (int i = 0; i < ms.nr_righe(); i++)
            for (int j = 0; j < ms.nr_colonne(); j++)
                ms.set(i,j, ThreadLocalRandom.current().nextDouble(0,14));

        System.out.println(ms);
        System.out.println(MatriceSparsa.determinanteL(ms));

    }

    public MatriceSparsaImpl( int n , int m ){

        this.ms = new HashMap<>();
        this.n = n;
        this.m = m;
    }

    @Override
    public int nr_righe() {
        return n;
    }

    @Override
    public int nr_colonne() {
        return m;
    }

    @Override
    public double get(int i, int j) {
        if(i>n || j>m) throw new IndexOutOfBoundsException();
        if(!(ms.containsKey(i))) return 0;
        Map<Integer,Double> m = ms.get(i);

        if(m.containsKey(j)) return m.get(j);
        return 0;
    }

    @Override
    public void set(int i, int j, double v) {

        if(v == 0 ) {
            ms.remove(i);
            if (!ms.containsKey(i)) return;
            if (!ms.get(i).containsKey(j)) return;
            ms.get(i).remove(j);
            return;
        }

        if (!ms.containsKey(i)) ms.put(i, new HashMap<>());
        ms.get(i).put(j, v);
    }

    @Override
    public MatriceSparsa factory(int nr_righe, int nr_colonne) {
        return new MatriceSparsaImpl(nr_righe,nr_righe);
    }
}
