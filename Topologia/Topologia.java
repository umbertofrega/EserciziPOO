package Topologia;

import Labirinto.Backtracking;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Topologia extends Backtracking<Segmento,Segmento> {

    private LinkedList<Segmento> percorso = new LinkedList<>();
    private LinkedList<Segmento> segmenti = new LinkedList<>();
    private Segmento fine;
    private Segmento inizio;
    private String regex = "[[0-9]+|[ ]+]{3}";

    public static void main(String[] args) {
        LinkedList<Segmento> segmentos = new LinkedList<>();
        segmentos.add(new Segmento("10 4 7"));
        segmentos.add(new Segmento("11 12 11"));
        segmentos.add(new Segmento("12 4 9"));
        segmentos.add(new Segmento("14 6 12"));

        Topologia t =new Topologia(segmentos);
        t.risolvi();

    }

    public Topologia (LinkedList<Segmento> segmenti){

        this.segmenti = segmenti;
        LinkedList<Segmento> s = (LinkedList<Segmento>) segmenti.clone();

        s.sort(null);
        percorso.add(s.getFirst());

        this.fine = s.getLast();
        this.inizio = s.getFirst();
    }

    public Topologia()  throws FileNotFoundException {
        File f = new File(" ");
        if(!(f.exists())) throw new FileNotFoundException();
        Scanner sc = null;

        sc = new Scanner(f);

        while ( sc.hasNext() ){
            String s = sc.nextLine();
            if(!(s.matches(regex))) throw new IllegalArgumentException("Testo del File Invalido");
            segmenti.add(new Segmento(s));
        }

    }

    @Override
    public int hashCode() {
        return percorso.hashCode();
    }


    @Override
    protected boolean assegnabile(Segmento s,Segmento segmento2) {
        Segmento c = percorso.getLast();

        if(percorso.contains(s)) return false;

        return (s.consecutivo(c) && s.getX()>c.getX());
    }

    @Override
    protected void assegna(Segmento ps, Segmento segmento) {
        percorso.add(segmento);
    }

    @Override
    protected void deassegna(Segmento ps, Segmento segmento) {
        percorso.removeLast();
    }

    @Override
    protected void scriviSoluzione(Segmento segmento) {
        StringBuilder sb = new StringBuilder(percorso.size()*2);
        sb.append("START\n");
        for(Segmento s : percorso) {
            sb.append(s.getX());
            sb.append("-");
        }

        if (sb.length() > 1) sb.setLength(sb.length() - 1);
        sb.append("\nEND");

        System.out.println(sb.toString());

    }

    @Override
    protected boolean esisteSoluzione(Segmento segmento) {
        return (segmento.equals(fine));

    }

    @Override
    protected List<Segmento> puntiDiScelta() {
        return segmenti;
    }

    @Override
    protected Collection<Segmento> scelte(Segmento segmento) {

        LinkedList<Segmento> s = new LinkedList<>();
        s.add(inizio);
        return s;

    }

}
