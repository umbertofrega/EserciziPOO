package Azienda;

import java.util.*;

public abstract class Stanza implements Comparable<Stanza>{

    private int telefono;
    private LinkedList<Persona> impiegati = new LinkedList<>();
    private LinkedList<Persona> persone = new LinkedList<>();

    public void aggiungiPersona(Persona p){
        if(impiegati.contains(p)) return;

        if(p==null) throw new IllegalArgumentException();

        persone.add(p);

    }

    public int getTelefono(){
        return telefono;
    }

    public LinkedList<Persona> getImpiegati() {
        return this.impiegati;
    }

    public Iterator<Persona> impiegati() {

        Iterator<Persona> p = impiegati.iterator();
        return p;

    }
    public Stanza(int telefono ) {

        if(telefono<10000000) throw new IllegalArgumentException();

        this.telefono = telefono;

    }
}


