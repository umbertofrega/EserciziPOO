package pn;

public class ArcoOut extends Arco{

    public ArcoOut(Posto p, int n) {
        super(p, n);
    }

    @Override
    public Posto getPosto() {
        return super.getPosto();
    }

    public int getPeso() {return super.getPeso(); }

    public void setPosto(int i) {
        super.setPosto(new Posto(i));
    }

}
