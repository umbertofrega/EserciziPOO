package LIST;

import java.util.*;


public class ArrayList<T> extends AbstractList<T> {

    private T[] arr;
    private int n, size;

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(2);

        al.addFirst(139);
        al.addFirst(10);
        al.addLast(213);
        System.out.println(al);

    }

    public void set(int i , T x){

        if(i>size) throw new IndexOutOfBoundsException();

        arr[i]=x;

    }

    @Override
    public void clear() {
        super.clear();
        size = 0;
    }

    @Override
    public T getFirst() {
        return arr[0];
    }

    @Override
    public T getLast() {
        return arr[size];
    }

    public T get(int i ){
        if(i>size) throw new IndexOutOfBoundsException();

        return arr[i];

    }

    public void sort(){

        T[] a = (T[]) new Object[size];
        for (int i = 0; i < n; i++)
            if(arr[i] != null)
                a[i] = arr[i];

        Arrays.sort(a);

        for (int i = 0; i < size; i++)
            arr[i] = a[i];
    }

    public void sort(Comparator<T> c){
        T[] a = (T[]) new Object[size];
        for (int i = 0; i < n; i++)
            if(arr[i] != null)
                a[i] = arr[i];

        Arrays.sort(a,c);

        for (int i = 0; i < size; i++)
            arr[i] = a[i];
    }

    public ArrayList( int n ){
        if(n<=0) throw new IllegalArgumentException();

        this.n=n;
        this.arr = (T[]) new Object[n];
        size = 0;

    }

    @Override
    public void add(T x) {
        super.add(x);
        size++;
    }

    @Override
    public boolean isFull() {
        return arr.length == size();
    }

    @Override
    public ListIterator<T> listiterator() {
        return new ArrayListIterator<T>();
    }

    @Override
    public ListIterator<T> listiterator(int from) {
        return new ArrayListIterator<>(from);
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private class ArrayListIterator<E> implements ListIterator<E>{

        int pre;
        int curr;
        Movimento mov;
        boolean rimuovibile;

        public ArrayListIterator() {
            int pre = 0;
            int curr = 0;
            Movimento mov = Movimento.UNKNOWN;
            boolean rimuovibile = false;
        }

        public ArrayListIterator( int n ){
            if(n==0){
                return;
            }

            int pre = n--;
            int curr = n;

            Movimento mov = Movimento.UNKNOWN;
            boolean rimuovibile = false;

        }


        @Override
        public boolean hasNext() {
            if(curr>=n) return false;

            return arr[curr]!=null;
        }

        @Override
        public E next() {
            if(!hasNext()) throw new NoSuchElementException();


            E info = (E) arr[curr];

            curr++;
            pre++;

            mov = Movimento.FORWARD;
            rimuovibile = true;
            return info;
        }

        @Override
        public boolean hasPrevious() {

            return curr == 0;

        }

        @Override
        public E previous() {
            if(!hasPrevious()) throw new IllegalArgumentException();

            E info = (E) arr[curr];

            curr--;
            pre--;

            mov = Movimento.BACKWARD;
            rimuovibile = true;

            return info;
        }

        @Override
        public int nextIndex() {
            return curr++;
        }

        @Override
        public int previousIndex() {
            return pre;
        }

        @Override
        public void remove() {
            if(rimuovibile == false)
                throw new IllegalStateException();
//            if(curr == pre)
//                throw new IllegalStateException();

            if(!hasNext()){
                arr = Arrays.copyOfRange(arr,0,n-1);
                n = arr.length;
                size--;
                return;
            }

            T[] a = Arrays.copyOfRange(arr,0,curr);
            T[] a2 = Arrays.copyOfRange(arr,curr+1,n);

            T[] a3 = (T[]) new Object[n-1];

            if(a.length==0) {
                arr = a2.clone();
                n = arr.length;
                size--;
                return;
            }

            if(a2.length==0){
                arr = a.clone();
                n = arr.length;
                size--;
                return;
            }

            for (int i = 0; i < curr-1; i++)
                a3[i]=a[i];

            for (int i = 0; i+curr < n-1; i++) {
                a3[i + curr] = a2[i];
            }

            arr = a3.clone();
            n = arr.length;
            size--;

        }

        @Override
        public void set(E t) {
            Object ti = (Object) t;

            arr[curr] = (T) ti;

        }

        @Override
        public void add(E t) {

            if(size == n){
                T[] arr2 = (T[]) new Object[n*2];

                arr2 = (T[]) arr.clone();

                arr = arr2.clone();
                n*=2;
            }

            if(size == 0){
                arr[0] = (T) t;
                size++;
                return;

            }

            T[] a2 = Arrays.copyOfRange(arr,0,curr+1);
            T[] a3 = Arrays.copyOfRange(arr,curr,n+1);
            T[] a = (T[]) new Object[n+1];


//            if(a2.length == 0){
//                a[0] = (T) t;
//                for (int i = 0; i < a3.length; i++)
//                    a[i+1] = a3[i];
//
//            }
//
//            if(a3.length == 0){
//                a[n+1] = (T) t;
//                for (int i = 0; i < a3.length; i++)
//                    a[i] = a3[i];
//            }
//            else {
                int i = 0;
                for (; i < a2.length; i++)
                    a[i] = a2[i];

                a[i+1] = (T) t;

                for (int j = 0; j < a3.length; j++)
                    a[curr+j]=a3[j];





            arr = a.clone();
            n = arr.length;
            size++;
        }
    }



    private enum Movimento {

        UNKNOWN, FORWARD, BACKWARD;

    }


}
//
//
//            if( pre == 0 ){
//
//                T[] a = (T[])new Object[n+1];
//
//                a[0] = (T) t;
//
//                for (int j = 0; j < n; j++) {
//                    a[j+1] = arr[j];
//
//                }
//
//                arr = a.clone();
//                n = arr.length;
//                size++;
//                return;
//            }
//
//            int i = 0;
//            while(true) {
//                i++;
//                if (i >= n) {
//                    T[] arr2 = (T[]) new Object[n * 2];
//
//                       for (int j = 0; j < n; j++) {
//                        if(j<n)
//                            arr2[j]=arr[j];
//                        if(j>n)
//                            arr2[j]=null;
//                    }
//
//                    arr = arr2;
//                    n *= 2;
//                }
//
//                if (arr[i] == null) break;
//            }
//
//            arr[i] = (T) t;
//