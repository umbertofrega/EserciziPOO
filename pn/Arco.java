package pn;

public abstract class Arco extends Entita{
    protected Posto posto;
    protected int peso;

    public Arco(Posto p , int n){

        if ( p == null ) throw new IllegalArgumentException();

        this.posto = p;
        this.peso = n;

    }

    @Override
    public String toString() {
        return this.getPosto()+","+this.getPeso();
    }

    public void setPosto(Posto posto) {
        this.posto = posto;
    }

    public Posto getPosto() {
        return posto;
    }

    public int getPeso() {
        return peso;
    }

}
