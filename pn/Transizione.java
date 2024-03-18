package pn;

import java.util.*;

public class Transizione extends Entita {

    List<ArcoIn> preSet = new ArrayList<>();
    List<ArcoOut> postSet = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("ArchiIn=[");

        for (ArcoIn a : preSet)
            sb.append(a.toString());

        sb.append("]");
        sb.append("\n");
        sb.append("ArchiOut=[");

        for (ArcoOut a : postSet)
            sb.append(a.toString());

        sb.append("]");
        sb.trimToSize();
        return sb.toString();
    }

    public Transizione(List<ArcoIn> preSet, List<ArcoOut> postSet ){

        this.postSet=postSet;
        this.preSet=preSet;

    }

    boolean abilitata(){
        if(preSet.size()==0) return true;

        for (ArcoIn a : preSet) {
            Posto cur = a.getPosto();
            if(cur.getMarcatura()<a.getPeso()){
                return false;
            }
        }
        return true;
    }

    void sparo(){
        if(!abilitata()) throw new IllegalStateException();

        for(ArcoIn a : preSet ) {
            int peso = a.getPeso();
            int marcatura = a.getPosto().getMarcatura();
            a.setPosto(0);
            peso = marcatura-peso;
            for (ArcoOut o : postSet ) {

                Posto p = o.getPosto();
                o.setPosto(p.getMarcatura()+peso);

            }
        }

    }

}
