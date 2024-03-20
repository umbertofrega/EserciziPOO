package Sudoku;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class Backtracking3<P, S> {

    private List<P> ps;

    protected abstract boolean assegnabile(P p, S s);

    protected abstract void assegna(P ps, S s);

    protected abstract void deassegna(P ps, S s);

    protected abstract void scriviSoluzione(P p);

    private P primoPuntoDiScelta() {
        return ps.get(0);
    }//primoPuntoDiScelta

    private P prossimoPuntoDiScelta(P p) {
        if (esisteSoluzione(p))
            throw new NoSuchElementException();
        int i = ps.indexOf(p);
        return ps.get(i + 1);
    }//prossimoPuntoDiScelta

    private boolean ultimoPuntoDiScelta(P p) {
        int i = ps.indexOf(p);
        return i == ps.size() - 1;
    }

    abstract protected boolean esisteSoluzione(P p);//esisteSoluzione

    protected boolean ultimaSoluzione(P p) {
        return false; //cerca tutte le possibili soluzioni
    }//ultimaSoluzione

    //factory
    protected abstract List<P> puntiDiScelta();

    protected abstract Collection<S> scelte(P p);

    protected void tentativo(P p) {
        Collection<S> sa = scelte(p); //scelte ammissibili per p
        for (S s : sa) {
            if (ultimaSoluzione(p)) break;
            if (assegnabile(p, s)) {
                assegna(p, s);
                if (esisteSoluzione(p)) scriviSoluzione(p);
                else if (!ultimoPuntoDiScelta(p))
                    tentativo(prossimoPuntoDiScelta(p));
                deassegna(p, s);
            }
        }
    }//tentativo

    protected void risolvi() {
        ps = puntiDiScelta();
        tentativo(primoPuntoDiScelta());
    }//risolvi

}//Backtracking
