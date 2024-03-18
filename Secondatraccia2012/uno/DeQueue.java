package Secondatraccia2012.uno;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public interface DeQueue<T> extends Iterable<T>{
    default int size(){
        int n = 0;
        for ( T x : this )
            n++;
        return n;
    } //ritorna il numero di elementi della collezione

    default boolean contains(T x){
        for ( T el : this )
            if ( el.equals(x)) return true;
        return false;
    }//ritorna true se x è presente nella collezione, false altrimenti

    default void clear(){
        Iterator<T> li = this.iterator();
        while ( li.hasNext()) {
            li.next();
            li.remove();
        }
    }//svuota la collezione

    void offer(T e); //aggiunge e in coda

    default T poll(){
        Iterator<T> it = this.iterator();
        if (!it.hasNext()) return null;
        T e = it.next();
        it.remove();
        return e;
    } //rimuove e ritorna l'elemento di testa

    void push(T e); //aggiunge e in testa

    boolean isEmpty();

    default T pop(){
        if ( this.isEmpty() ) throw new NoSuchElementException();
        return poll();
    }//rimuove e ritorna l'elemento di testa

    default T peek(){
        Iterator<T> it = this.iterator();
        if ( !it.hasNext()) throw new NoSuchElementException("La lista è vuota ");
        T e = it.next();
        return e;
    } //come poll() o pop() ma senza rimuovere l'elemento


}
