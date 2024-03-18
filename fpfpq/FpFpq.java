package fpfpq;

import java.io.*;
import java.util.Scanner;

public class FpFpq extends StatisticaMap{

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        String nomeFile = null;
        File f = null;
        do {
            System.out.print("Nome file testo: ");
            nomeFile = sc.nextLine();
            f = new File("C:\\Users\\umber\\OneDrive\\Desktop\\Cartelle\\Scuola\\Uni\\Secondo Anno\\Primo Semestre\\poo\\"+nomeFile+".txt");
            if (!f.exists()) System.out.println("File " + nomeFile + " inesistente! Ridarlo");

        } while (!f.exists());

        Statistica stat = new StatisticaMap();
        BufferedReader b = new BufferedReader(new FileReader(f));

        for(;;) {
            String line = b.readLine();

            if(line==null) break;
            if(line.length()==0) continue;
            Scanner s = new Scanner(line);
            String p = null;
            while(s.hasNext()) {

                String w = s.next().toUpperCase();
                stat.arrivoParola(w);

                if ( p!= null ){
                    stat.paroleConsecutive(p,w);
                }

                p = w;
            }

            s.close();
        }
        b.close();


        System.out.print("Parola target=");
        String target = sc.nextLine().toUpperCase();
        sc.close();

        System.out.println("Statistica d'uso delle parole:");
        System.out.println(stat);

        PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\umber\\OneDrive\\Desktop\\Cartelle\\Scuola\\Uni\\Secondo Anno\\Primo Semestre\\poo\\statistica.txt"));
        pw.println(stat);
        pw.close();


        System.out.println("Parola che piu' verosimilmente segue " + target + "=" + stat.parolaCheSeguePiuFrequente(target));

        System.out.println("Parola che meno verosimilmente segue " + target + "=" + stat.parolaCheSegueMenoFrequente(target));

    }





}
