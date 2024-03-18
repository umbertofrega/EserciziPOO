package fpfpq;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class StatisticaMap implements Statistica {
    private Map<String,Integer> fp = new TreeMap<>();
    private Map<String, Map<String, Integer>> fpq = new TreeMap<>();

    @Override
    public void arrivoParola(String p) {

        if(!fp.containsKey(p)) {
            fp.put(p,0);
            fpq.put(p, new HashMap<>());
        }
        else fp.put(p,fp.get(p)+1);

    }

    @Override
    public void paroleConsecutive(String p, String d) {
        if(!fp.containsKey(p) || !fp.containsKey(d)) throw new RuntimeException();

        Map<String,Integer> m = fpq.get(p);
        if(m.containsKey(d)) m.put(d,m.get(d)+1);
        else m.put(d,0);

    }

    @Override
    public int numTotaleParole(){
        int np=0;

        for( String i : fp.keySet() )
            np+= fp.get(i);

        return np;
    }

    @Override
    public int frequenza(String p) {
        if(!fp.containsKey(p)) return 0;

        return fp.get(p)/numTotaleParole();
    }

    @Override
    public int frequenzaCoppia(String p, String q) {
        if( !fpq.containsKey(p) ) throw new RuntimeException();
        Map<String,Integer> m = fpq.get(p);

        if( !m.containsKey(q) ) throw new RuntimeException();

        return m.get(q);
    }

    @Override
    public String parolaCheSeguePiuFrequente(String target) {

        if(!fpq.containsKey(target)) throw new RuntimeException("non c'è ");

        Map<String, Integer> m = fpq.get(target);
        int max = -1;
        String ret = null;
        for (String s : m.keySet())
            if (m.get(s)>max) {
                ret=s;
                max = m.get(s);
            }
        return ret;

    }

    @Override
    public String parolaCheSegueMenoFrequente(String target) {
        if(!fpq.containsKey(target)) throw new RuntimeException("non c'è");

        Map<String, Integer> m = fpq.get(target);
        int min = Integer.MAX_VALUE;
        String ret = null;
        for (String s : m.keySet())
            if (m.get(s)<min) {
                ret=s;
                min = m.get(s);
            }
        return ret;
    }

    @Override
    public String toString() {
        return fpq.toString()+" e "+fp.toString();
    }
}
