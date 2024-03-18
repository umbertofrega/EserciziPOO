package Secondatraccia2012.uno;

import java.util.Iterator;

public abstract class AbstractDeQueue<T> implements DeQueue<T> {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("[");
        for ( T x : this ) {
            sb.append(x);
            sb.append(",");
        }
        sb.trimToSize();
        sb.replace(sb.length()-1,sb.length(),"]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object x) {
        if (!(x instanceof DeQueue)) return false;
        if ( x == this) return true;
        DeQueue<T> deq = (DeQueue<T>)x;
        if ( deq.size()!=size()) return false;

        Iterator<T> it = this.iterator(), it2 =deq.iterator();
        while (it.hasNext())
            if (!(it.next().equals(it2.next()))) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int h = 0;
        for ( T x : this )
            h = h * 29 + x.hashCode();
        return h;
    }

}
