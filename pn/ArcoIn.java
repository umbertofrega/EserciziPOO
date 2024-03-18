package pn;

public class ArcoIn extends Arco{


    public ArcoIn(Posto p, int n) {

        super(p, n);
    }

    @Override
    public Posto getPosto() {
        return super.getPosto();
    }

    @Override
    public int getPeso() {
        return super.getPeso();
    }

    public void setPosto(int i) {
        super.setPosto(new Posto(i));
    }
}
