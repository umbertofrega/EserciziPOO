package LIST;

import java.util.ListIterator;

public abstract class AbstractList<T> implements List<T> {
    @Override
    public String toString() {
        if(size()==0)
            return "[]";
        StringBuilder sb = new StringBuilder((size()*2)+3);
        ListIterator<T> li = listiterator();
        sb.append("[");

        while (li.hasNext()){

            sb.append(li.next());
            sb.append(",");

        }
        sb.delete(sb.length()-1,sb.length());
        sb.trimToSize();
        sb.append("]");

        return sb.toString();
    }

    public String reverseToString(){
        StringBuilder sb = new StringBuilder((size()*2)+3);
        ListIterator<T> li = listiterator(size());
        sb.append("[");

        while (li.hasPrevious()){

            sb.append(li.previous());
            sb.append(",");

        }
        sb.delete(sb.length()-1,sb.length());
        sb.trimToSize();
        sb.append("]");

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {

        if(!(obj instanceof List<?>)) return false;
        if(this == obj ) return false;
        List<T> x = (List<T>) obj;

        if(x.size()!=this.size()) return false;
        ListIterator<T> li = listiterator();
        ListIterator<T> l2 = x.listiterator();

        while (li.hasNext()) {
            if (!(li.next().equals(l2.next())))
                return false;
        }

        return true;

    }

    @Override
    public int hashCode() {
        ListIterator<T> li = listiterator();
        int hash = 33;
        while (li.hasNext()){
            hash *= li.next().hashCode();
        }
        return hash;
    }
}
