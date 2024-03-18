package pn;

import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String,Posto> p= new HashMap<>();
        LinkedList<Transizione> t = new LinkedList<>();

        Posto p1 = new Posto(2);
        Posto p2 = new Posto();
        Posto p3 = new Posto();
        Posto p4 = new Posto();

        p.put("p1",p1);
        p.put("p2",p2);
        p.put("p3",p3);
        p.put("p4",p4);

        ArcoIn arco = new ArcoIn(new Posto(2),1);
        t.add(new Transizione(Arrays.asList(new ArcoIn(p1,1)), Arrays.asList(new ArcoOut(p2,1))));
        t.add(new Transizione(Arrays.asList(new ArcoIn(p2,1)), Arrays.asList(new ArcoOut(p3,1))));
        t.add(new Transizione(Arrays.asList(new ArcoIn(p2,1)), Arrays.asList(new ArcoOut(p4,1))));
        t.add(new Transizione(Arrays.asList(new ArcoIn(p3,1),new ArcoIn(p4,1)), Arrays.asList(new ArcoOut(p1,1))));
        t.add(new Transizione(Arrays.asList(new ArcoIn(p4,1)), Arrays.asList(new ArcoOut(p1,1))));

    }

}
