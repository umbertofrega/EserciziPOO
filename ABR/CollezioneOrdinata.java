package ABR;


import java.util.Iterator;

public interface CollezioneOrdinata<T extends Comparable<? super T>> extends Iterable<T> {

    //size,clear,contains,add, remove,get,isEmpty,remove,get,isfull

    default int size(){
        Iterator<T> it = iterator();
        int cnt = 0;

        while(it.hasNext()) {
            it.next();
            cnt++;
        }
        return cnt;

    }

    default void clear(){
        Iterator<T> it = iterator();

        while(it.hasNext()){
            it.next();
            it.remove();
        }

    }

    default boolean contains(T x){
        for(T e: this){
            if(e.equals(x)) return true;

            if((e.compareTo(x)>0)) return false;
        }
        return false;
    }

    void add(T x);

    default void remove(T x){
        Iterator<T> it = iterator();
        while (it.hasNext()) {
            T y = it.next();
            if (y.equals(x)) {
                it.remove();
                break;
            }
            if((y.compareTo(x))>0) return;
        }
    }

    default T get(T x){
        for (T y : this ){
            if(y.equals(x)) return x;
            if((y.compareTo(x))>0) return null;
        }
        return null;
    }

    default boolean isEmpty(){
        return !iterator().hasNext();
    }

    default boolean isFull(){
        return false;
    }






}//CollezioneOrdinata
