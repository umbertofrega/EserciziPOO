package Labirinto;

import java.util.*;

public class PhoneBookImpl extends AbstractPhoneBook {

    LinkedList<Persona> rubrica = new LinkedList<>();

    @Override
    public int size() {
        return rubrica.size();
    }

    @Override
    public void clear() {
        rubrica.clear();
    }

    @Override
    public void remove(String r) {
        List<Persona> l = new ArrayList<Persona>();
        for (Persona p : rubrica) {
            String s = p.getNome()+""+p.getTelefono();
            if(s.matches(r))
                l.remove(p);
        }
    }

    @Override
    public List<Persona> search(String r) {
        List<Persona> l = new ArrayList<Persona>();
        for (Persona p : rubrica) {
            String s = p.getNome()+""+p.getTelefono();
            if(s.matches(r))
                l.add(p);
        }
        return l;
    }

    @Override
    public void resort(Comparator<Persona> c) {
        rubrica.sort(c);
    }

    @Override
    public void add(Persona p) {
        rubrica.add(p);
    }

    @Override
    public Iterator<Persona> iterator() {
        ListIterator li = rubrica.listIterator();
        return li;
    }
}
