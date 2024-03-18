package Azienda;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public abstract class Azienda {

    private LinkedList<Stanza> stanzas = new LinkedList<Stanza>();

    void aggiungiImpiegato(Persona p, int n) {
        for (Stanza s : stanzas){
            if (s.getTelefono() == n) {
                s.getImpiegati().add(p);
                break;
            }
        if(s.getImpiegati().contains(p))
            throw new IllegalArgumentException();
        }
    }


    public Iterator<Stanza> uffici() {

        Iterator<Stanza> st = stanzas.iterator();
        return st;

    }

    @Override
    public String
    toString() {
        final StringBuilder sb = new StringBuilder("Azienda{");
        sb.append("s=").append(stanzas);
        sb.append('}');
        return sb.toString();
    }

}

