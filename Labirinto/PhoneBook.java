package Labirinto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public interface PhoneBook extends Iterable<Persona>{
    int size();
    void clear();
    void add(Persona p);
    default void remove(String s){
        Iterator<Persona> it = iterator();
        while(it.hasNext()){
            Persona p = it.next();
            String s1 = p.getNome()+""+p.getNome();
            if(s1.matches(s)){
                it.remove();
            }
        }
    }
    default List<Persona> search(String s){
        Iterator<Persona> it = iterator();
        ArrayList<Persona> ar = new ArrayList<>();
        while(it.hasNext()){
            Persona p = it.next();
            String s1 = p.getNome()+""+p.getNome();
            if(s1.matches(s)){
                ar.add(p);
            }
        }
        return ar;
    }
    void resort(Comparator<Persona> c);
}
