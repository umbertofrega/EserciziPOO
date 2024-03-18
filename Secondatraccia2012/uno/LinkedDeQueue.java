package Secondatraccia2012.uno;

import Secondatraccia2012.uno.AbstractDeQueue;

import java.time.format.TextStyle;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedDeQueue<T> extends AbstractDeQueue<T> {
    private DeNodo<T> testa = null;
    private DeNodo<T> coda = null;
    private int size=0;

    @Override
    public void offer(T e) {
        DeNodo<T> deNodo = new DeNodo<>();
        deNodo.info=e;
        deNodo.next=null;
        if ( testa == null ) testa = deNodo;
        else coda.next = deNodo;
        coda = deNodo;
        size++;
    }

    @Override
    public void push(T e) {
        DeNodo<T> deNodo = new DeNodo<>();
        deNodo.info = e;
        deNodo.next = testa;
        testa = deNodo;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }



    @Override
    public Iterator<T> iterator() {
        return new LinkedDeQueueIterator<>();
    }


    private static class DeNodo<E>{
        E info;
        DeNodo<E> next;
    }
    private class LinkedDeQueueIterator<R> implements Iterator<R>{
        DeNodo<R> pre=null;
        DeNodo<R> cor = null;

        @Override
        public boolean hasNext() {
            if ( cor == null ) return testa != null;
            return cor.next!= null;
        }

        @Override
        public R next() {
            if (!hasNext()) throw new NoSuchElementException("Non si può richiamare next se non esistono elementi successivi");
            if ( cor == null ) cor = (DeNodo<R>) testa;
            else {
                pre = cor;
                cor = cor.next;
            }
            return cor.info;
        }

        @Override
        public void remove() {
            if (pre == cor) throw new IllegalStateException();
            if (cor == testa) {
                testa = testa.next;
                if ( testa == null ) coda = null;
            }
            else if ( cor == coda ){
                pre.next = null;
                coda = (DeNodo) pre;
            } else {

              pre.next = cor.next;

            }
            size--;
            cor = pre;
        }
    }

    public static void main(String[] args) {
        LinkedDeQueue<Integer> lq=new LinkedDeQueue<>();

    }
}
