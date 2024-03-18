package ABR;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ABR<T extends Comparable<? super T>> extends CollezioneOrdinataAstratta<T> {
    private Nodo<T> radice = null;

    public static void main(String[] args) {
        ABR<Integer> ab = new ABR<Integer>();
        ab.add(12);
        ab.add(5);
        ab.add(23);
        List<Integer> l = new LinkedList<>();
        ab.inOrder(l);
        System.out.println(l);
        System.out.println(ab);
    }

    public void inOrder( List<T> l){
         inOrder(radice,l);
    }

    private void inOrder(Nodo<T> n, List<T> l) {
         if (n!=null) {
            inOrder(n.fS,l);
            l.add(n.info);
            inOrder(n.fD,l);
         }

    }


    @Override
    public void remove(T x){ radice = remove(radice, x ); }

    private Nodo<T> remove(Nodo<T> n, T x ){
        if( n == null ) return n;

        if ( n.info.compareTo(x)>0){
             n.fS = remove(n.fS,x);
             return n;
        }

        if ( n.info.compareTo(x)<0){
            n.fD = remove(n.fD,x);
            return n;
        }

        if(n.fD == null && n.fD == null )
            return null;

        if(n.fD == null )
            return n.fS;

        if(n.fS == null )
            return n.fD;

        if (n.fD.fS == null) {
            n.info = n.fD.info;
            n.fD = n.fD.fD;
            return n;
        }

        Nodo<T> padre = n.fD, figlio = n.fD.fS;
        while (figlio.fS != null) {
            padre = figlio;
            figlio = figlio.fS;
        }

        n.info = figlio.info;
        padre.fS = figlio.fD;
        return n;

    }


    private void preOrder(List<T> l){
        preOrder(radice,l);
    }

    private void preOrder( Nodo<T> n,List<T> l ){
        if (n!=null) {
            l.add(n.info);
            preOrder(n.fD,l);
            preOrder(n.fD,l);
        }
    }

    private void postOrder(List<T> l){
        preOrder(radice,l);
    }

    private void postOrder( Nodo<T> n,List<T> l ){
        if (n!=null) {
            preOrder(n.fD,l);
            preOrder(n.fD,l);
            l.add(n.info);
        }
    }
    @Override
    public void add(T x) {
        radice = add(radice, x);

    }//add

    private Nodo<T> add(Nodo<T> nodo, T x) {

        if (nodo == null) {
            Nodo<T> n = new Nodo<>();
            n.info = x;
            return n;
        }

        if (nodo.info.compareTo(x) > 0) nodo.fS = add(nodo.fS, x);
        else nodo.fD = add(nodo.fD, x);

        return nodo;

    }//add

    @Override
    public T get(T x) {
        return get(radice, x).info;
    }

    private Nodo<T> get(Nodo<T> n, T x){
        if(n==null) return null;

        if(n.info.compareTo(x)>0)
            return get(n.fS,x);
        if(n.info.compareTo(x)<0)
            return get(n.fD,x);

        return n;
    }




    @Override
    public Iterator<T> iterator() {
        return new ABRIterator() ;
    }


    private class ABRIterator implements Iterator<T>{
        private List<T> l = new LinkedList<>();
        private Iterator<T> it ;
        private T info;


        public ABRIterator() {
            inOrder(l);
            it = l.iterator();
        }

        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        @Override
        public T next() {
            info = it.next();
            return info;
        }

        @Override
        public void remove() {
            if (info == null) throw new IllegalStateException();
            it.remove();
            ABR.this.remove(info);
            info = null;

        }
    }

    private class Nodo<E>{
        private E info;
        private Nodo<E> fS;
        private Nodo<E> fD;

        @Override
        public String toString() {
            return info.toString();
        }

    }

}
