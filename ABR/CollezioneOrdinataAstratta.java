package ABR;

import java.util.Iterator;

public abstract class CollezioneOrdinataAstratta<T extends Comparable<? super T> > implements CollezioneOrdinata<T> {

    @Override
    public String toString() {
        Iterator<T> it = iterator();
        StringBuilder sb = new StringBuilder(size()*2+3);
        sb.append("[");
        while (it.hasNext()){
            sb.append(it.next());
            if(it.hasNext()) sb.append(", ");
        }

        sb.append("]");
        return sb.toString();

    }

    @Override
    public boolean equals(Object obj) {
        if( obj == this ) return true;
        if(!(obj instanceof CollezioneOrdinata<?>)) return false;
        CollezioneOrdinataAstratta<T> x = (CollezioneOrdinataAstratta<T>) obj;
        if(x.size()!=this.size()) return false;

        for (T e : this ){
            if(!x.contains(e)) return false;
        }

        return true;

    }

    @Override
    public int hashCode() {
        int h = 7;
        for (T e : this){
            h*=e.hashCode();
        }
        return h;
    }
}

