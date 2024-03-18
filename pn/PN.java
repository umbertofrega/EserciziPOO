package pn;

import java.sql.SQLOutput;
import java.util.*;

public class PN {

    private Map<String,Posto> postoMap;
    private LinkedList<Transizione> T;

    private LinkedList<Transizione> a = new LinkedList<>();
    private LinkedList<Transizione> d = new LinkedList<>();

    public static void main(String[] args) {
        Map<String,Posto> p = new HashMap<>();
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

        PN pn = new PN(p,t);
        System.out.println(pn);
        pn.singleStep();
        System.out.println(pn);

    }

    public PN(Map<String,Posto> postoMap,  LinkedList<Transizione> tList) {

        this.postoMap=postoMap;
        this.T=tList;

        for (Transizione t: T )
            if(t.abilitata())
                a.add(t);
            else
                d.add(t);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PN)) return false;
        PN pn = (PN) o;
        return Objects.equals(postoMap, pn.postoMap) && Objects.equals(T, pn.T) && Objects.equals(a, pn.a) && Objects.equals(d, pn.d);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postoMap, T, a, d);
    }

    void singleStep(){

        if(a.size()==0) {
            System.out.println("DeadLock!");
            throw new IllegalStateException();
        }

        Collections.shuffle(a);
        Transizione curr = a.pop();
        curr.sparo();

        d.add(curr);

        for(Transizione t : a)
            if(!(t.abilitata()))
                d.add(a.pop());

        for(Transizione t : d)
            if(t.abilitata())
                a.add(d.pop());

    }

    void multipleSteps( int n ){
        while (n<0){
            try {
                singleStep();
            }
            catch (IllegalStateException e){
                break;
            }
            System.out.println(postoMap);
        }

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PN{");
        sb.append("postoMap=").append(postoMap);
        sb.append(",\n T=").append(T);
        sb.append('}');
        return sb.toString();
    }
}
