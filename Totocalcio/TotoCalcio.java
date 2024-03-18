package Totocalcio;

import Labirinto.Backtracking;

import java.util.*;

public class TotoCalcio extends Backtracking<char[],Character> {

    private char[][] c;
    int numsoluzione = 1;

    private char[] colonna;
    private ArrayList<Character> soluzione = new ArrayList<>(13);
    private ArrayList<ArrayList<Character>> soluzioni = new ArrayList<>();

    public static void main(String[] args) {
        char[][] c = {
                {'2'},
                {'1','X'},
                {'X'},
                {'1','2','X'},
                {'1','X'},
                {'2'},
                {'1'},
                {'1','2','X'},
                {'X'},
                {'1'},
                {'2','1'},
                {'X'},
                {'2'},
        };
        TotoCalcio t = new TotoCalcio(c);
        t.risolvi();
    }

    public TotoCalcio(char[][] c){
        this.c = c;
        this.colonna = new char[c.length];
        for (int i = 0; i < c.length; i++) {
            colonna[i] = c[i][0];
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < c.length; i++) {
            sb.append(Arrays.toString(c[i]));
            sb.append(",\n");
        }
        sb.setLength(sb.length()-2);
        sb.append("]");
        return sb.toString();
    }

    @Override
    protected boolean assegnabile(char[] chars,Character character ) {
        return true;
    }

    @Override
    protected void assegna( char[] chars, Character ps) {
        soluzione.add(ps);
    }

    @Override
    protected void deassegna( char[] chars, Character ps) {
        soluzione.remove(soluzione.size()-1);
    }

    @Override
    protected void scriviSoluzione(char[] character) {
        System.out.print(numsoluzione+" ");
        System.out.println(soluzione);
        numsoluzione++;

    }

    @Override
    protected boolean esisteSoluzione(char[] character) {
        return soluzione.size() == colonna.length;
    }

    @Override
    protected List<char[]> puntiDiScelta() {
        List<char[]> li = new LinkedList<>();
        for (int i = 0; i < c.length; i++) {
            li.add(c[i]);
        }
        return li;
    }

    @Override
    protected Collection<Character> scelte(char[] character) {
        Collection<Character> co = new LinkedList<>();
        for (int i = 0; i < character.length; i++) {
            co.add(character[i]);
        }
        return co;
    }

}

//
//private char[][] c;
//
//private char[] colonna;
//
//public static void main(String[] args) {
//    char[][] c = {
//            {'2'},
//            {'1','X'},
//            {'X'},
//            {'1','2','X'},
//            {'1','X'},
//            {'2'},
//            {'1'},
//            {'1','2','X'},
//            {'X'},
//            {'1'},
//            {'2','1'},
//            {'X'},
//            {'2'},
//    };
//    TotoCalcio t = new TotoCalcio(c);
//    System.out.println(t);
//}
//
//public TotoCalcio(char[][] c){
//    this.c = c;
//    this.colonna = new char[c.length];
//    for (int i = 0; i < c.length; i++) {
//        colonna[i] = c[i][0];
//    }
//}
//
//@Override
//public String toString() {
//    StringBuilder sb = new StringBuilder();
//    sb.append("[");
//    for (int i = 0; i < c.length; i++) {
//        sb.append(Arrays.toString(c[i]));
//        sb.append(",\n");
//    }
//    sb.setLength(sb.length()-2);
//    sb.append("]");
//    return sb.toString();
//}