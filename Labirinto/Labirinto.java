package Labirinto;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Labirinto extends Backtracking<Integer,Integer>{

    HashMap<Integer,ArrayList<Integer>> lab = new HashMap<>();
    ArrayList<Integer> sol = new ArrayList<>();

    public Labirinto() {
//        Scanner s = null;
//        try {
//
//            File f = new File(" ");
//            s = new Scanner(f);
//
//        }catch (IOException e){
//            throw new IllegalArgumentException();
//        }
//
//        while (s.hasNext()){
//            StringTokenizer st = new StringTokenizer(s.nextLine());
//            if(st.countTokens()!=5) throw new IllegalArgumentException("File Malformato");
//            int k =Integer.parseInt(st.nextToken());
//            ArrayList<Integer> n = new ArrayList<>();
//            while (st.hasMoreTokens()) {
//
//                try {
//                    n.add(Integer.parseInt(st.nextToken()));
//                } catch (NumberFormatException e) {
//                    throw new IllegalArgumentException("File Malformato");
//                }
//            }
//
//            lab.put(k,n);
//
//        }


    }

    @Override
    protected boolean assegnabile(Integer integer, Integer integer2) {
        return ( integer!= 0 );
    }

    @Override
    protected void assegna(Integer ps, Integer integer) {

        sol.add(integer);

    }

    @Override
    protected void deassegna(Integer ps, Integer integer) {
        sol.remove(integer);
    }

    @Override
    protected void scriviSoluzione(Integer integer) {

        System.out.println(sol);

    }

    @Override
    protected boolean esisteSoluzione(Integer integer) {
        return integer == lab.size();
    }

    @Override
    protected List<Integer> puntiDiScelta() {
        return (List<Integer>) lab.keySet();
    }

    @Override
    protected Collection<Integer> scelte(Integer integer) {
        return lab.get(integer);
    }

}
