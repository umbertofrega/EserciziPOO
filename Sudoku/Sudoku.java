package Sudoku;

import java.util.*;
import java.util.Random;
import Labirinto.Backtracking;
import Totocalcio.Pair;


public class Sudoku extends Backtracking<Pair, Integer> {

    private int[][] sudoku = new int[9][9];
    private ArrayList<Pair> n = new ArrayList<>();
    int numSoluzioni;

    public static void main(String[] args) {

        Sudoku s = new Sudoku();
        s.colloca(0,0);
        s.risolvi();
    }


    public Sudoku(){

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(sudoku[i][j]!= 10)
                    sudoku[i][j] = 0;
            }
        }
    }

    public Sudoku( int[][] imp ){
        for (int i = 0; i < imp.length; i++) {
            for (int j = 0; j < imp.length; j++) {
                sudoku[i][j] = imp[i][j];
                n.add(new Pair(i,j));
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(n.contains(new Pair(i,j)))
                    sudoku[i][j] = 0;
            }
        }
    }


    @Override
    protected boolean assegnabile(Pair ps, Integer s) {
        if( n.contains(ps) ) return false;
        for (int i = 0; i < sudoku.length; i++) {
            if(sudoku[ps.i()][i] == s ) return false;
            if(sudoku[i][ps.j()] == s ) return false;
        }
        int r=(ps.i()/3)*3, c=(ps.j()/3)*3;
        //verifica unicità nel quadrante di appartenenza
        for( int row=r; row<=r+2; ++row )
            for( int col=c; col<=c+2; ++col )
                if( sudoku[row][col]==s ) return false;

        return true;
    }

    @Override
    protected void assegna(Pair ps, Integer integer) {
        sudoku[ps.i()][ps.j()] = integer;
    }

    @Override
    protected void deassegna(Pair ps, Integer integer) {
        sudoku[ps.i()][ps.j()] = 0;
    }

    @Override
    protected void scriviSoluzione(Pair pair) {
        numSoluzioni++;
        System.out.println(numSoluzioni);
        for (int i = 0; i < sudoku.length; i++) {
            System.out.print(Arrays.toString(sudoku[i]));
            System.out.println();
        }

        if(numSoluzioni>30 ) System.exit(0);
    }

    @Override
    protected boolean esisteSoluzione(Pair pair) {
        if(pair.i() == sudoku.length-1 && pair.j() == sudoku.length-1) return true;
        return false;
    }

    @Override
    protected List<Pair> puntiDiScelta() {
        ArrayList<Pair> puntiDiS = new ArrayList<>();
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                puntiDiS.add(new Pair(i,j));
            }
        }
        return puntiDiS;
    }

    @Override
    protected Collection<Integer> scelte(Pair pair) {
        Collection<Integer> c = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            c.add(i);
        }
        return c;
    }

    private void colloca( int i, int j ) {

        for( int s=1; s<=9; ++s ) {
            if( assegnabile(new Pair(i,j),s) ) {
                assegna(new Pair(i,j), s);
                if( i==sudoku.length-1 && j==sudoku[i].length-1 )
                    scriviSoluzione(new Pair(0,0));
                else {
                    if( j==sudoku[i].length-1 ) colloca(i+1,0);
                    else colloca(i,j+1);
                }
                deassegna(new Pair(i,j),0);
            }
        }
    }


}//colloca



