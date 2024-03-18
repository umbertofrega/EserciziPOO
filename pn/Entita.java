package pn;

public abstract class Entita {

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Entita)) return false;
        Entita x = (Entita) obj;
        if ( x==this ) return true;
        if(this.toString()==x.toString()) return true;
        return false;

    }

    @Override
    public int hashCode() {

        return 139 * super.hashCode();

    }
}
