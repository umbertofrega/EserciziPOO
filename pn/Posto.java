package pn;

public class Posto extends Entita {
    private int Marcatura;

    @Override
    public String toString() {
        return this.Marcatura+"";
    }

    public Posto(int n) {
        this.Marcatura = n;
    }

    public Posto() {
        this.Marcatura = 0;
    }

    public int getMarcatura() {
        return this.Marcatura;
    }

    public void setMarcatura(int n) {
        this.Marcatura = n;
    }

}
