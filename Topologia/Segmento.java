package Topologia;

import java.util.Objects;
import java.util.StringTokenizer;

public class Segmento implements Comparable<Segmento>{
    private int x; // numero spazi
    private int yi; // numero spazi
    private int yf; // numero fine linea

    public Segmento(String s ){
        if(s == null) throw new IllegalArgumentException();

        StringTokenizer st = new StringTokenizer(s);

        this.x = Integer.parseInt(st.nextToken());
        this.yi = Integer.parseInt(st.nextToken());
        this.yf = Integer.parseInt(st.nextToken());

    }

    public int getX() {
        return x;
    }

    public int getYf() {
        return yf;
    }

    public int getYi() {
        return yi;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(4);
        sb.append(x).append("-");
        sb.append(yi).append("-");
        sb.append(yf);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Segmento)) return false;
        Segmento segmento = (Segmento) o;
        return getX() == segmento.getX() && getYi() == segmento.getYi() && getYf() == segmento.getYf();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getYi(), getYf());
    }

    public boolean consecutivo( Segmento s ){
        if ( this.x - s.x <= 5 ) return true;

        if( this.yi == s.yi || this.yi == s.yf ) return true;

        return false;
    }

    @Override
    public int compareTo(Segmento o) {
        if(this.x < o.x ) return -1;

        if(this.x == o.x ) return 0;

        return 1;

    }

}
