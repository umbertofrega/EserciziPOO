package Totocalcio;

import Labirinto.Backtracking;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Path extends Backtracking2<Pair,Pair>{

    private int[][] mat;
    private int N;
    private LinkedList<Pair> percorso = new LinkedList<>();

    public static void main(String[] args) {
        int[][] a={ {3,0,2,3},{2,4,2,1},{1,2,1,3},{1,1,1,2} };

        Path p = new Path(a);
        p.risolvi();

    }

    public Path( int[][] mat ) {

        if( mat.length== 0 ) return;

        for (int i = 0; i < mat.length; i++)
            if(mat[i].length!= mat.length) throw new IllegalArgumentException();

        this.mat = mat;
        percorso.add(new Pair(0,0));

    }

    @Override
    protected boolean assegnabile(Pair pair, Pair pair2) {

        if(pair.i() == pair.j()) return false;

        return (percorso.contains(pair));

    }

    @Override
    protected void assegna(Pair ps, Pair pair) {
        percorso.add(pair);
    }

    @Override
    protected void deassegna(Pair ps, Pair pair) {
        percorso.removeLast();
    }

    @Override
    protected void scriviSoluzione(Pair pair) {
        N++;
        System.out.print(N);
        System.out.println(percorso);
    }

    @Override
    protected boolean esisteSoluzione(Pair pair) {
        return percorso.getLast().i() == mat.length - 1 &&
                percorso.getLast().j() == mat.length - 1;
    }

    @Override
    protected List<Pair> puntiDiScelta() {
        percorso.addLast(new Pair(0,0));

        return percorso;
    }

    @Override
    protected Collection<Pair> scelte(Pair pair) {
        Collection<Pair> c = new LinkedList<>();

        int k = mat[pair.i()][pair.j()];

        c.add(new Pair(pair.i()+k,pair.j()));
        c.add(new Pair(pair.i()-k,pair.j()));
        c.add(new Pair(pair.i(),pair.j()+k));
        c.add(new Pair(pair.i(),pair.j()-k));

        return c;
    }

}
