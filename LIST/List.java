package LIST;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public interface List<T> extends Iterable<T> {

    default int size(){
        ListIterator<T> li = listiterator();
        int size = 0;
        while (li.hasNext()){
            li.next();
            size++;
        }
        return size;
    }
    default boolean contains( T x ){
        ListIterator<T> li = listiterator();
        while (li.hasNext()){
            if(li.next().equals(x))
                return true;
        }
        return false;
    }

    default void clear(){
        ListIterator<T> li = listiterator();
        while (li.hasNext()){
            li.next();
            li.remove();
        }
    }

    default void add( T x ){

        if(size() != 0)
            addLast(x);
        else addFirst(x);

    }

    default void addFirst( T x ){
        listiterator().add(x);
    }

    default void addLast( T x ){
        ListIterator<T> li = listiterator(size());

         li.add(x);
    }

    default T getFirst(){

        ListIterator<T> li = listiterator();
        if(li.hasNext()) return li.next();
        throw new NoSuchElementException();

    }

    default T getLast(){

        ListIterator<T> li = listiterator(size()-1);

        return li.next();

    }

    default T removeFirst(){

        ListIterator<T> li = listiterator();
        if(li.hasNext()){
            T info = li.next();
            li.remove();
            return info;
        }
        throw new NoSuchElementException();

    }

    default void remove( T x ){
        ListIterator<T> li = listiterator();

        while (li.hasNext()){
            if(li.next().equals(x)) {
                li.remove();
                return;
            }
        }

    }

    default boolean isEmpty(){

        return size()==0;

    }

    boolean isFull();

    ListIterator<T> listiterator();
    ListIterator<T> listiterator( int from );

}
