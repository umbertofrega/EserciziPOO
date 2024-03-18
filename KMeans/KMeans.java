package KMeans;

import java.io.*;
import java.util.*;
import KMeans.DataSet.*;

public class KMeans {

    Map<Punto,Integer> dataSet = new HashMap<>();
    Punto[] centroidi;

    public static void main(String[] args) {
        DataSet D = new DataSet();
        File f = new File("C:\\Users\\umber\\Desktop\\t.txt");

        try {
            D.crea(f,1000,500,1500);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        KMeans k = new KMeans(f,4);
        k.run(1);
        System.out.println(k);
    }

    public KMeans(File f, int k ){
        this.centroidi = new Punto[k];
        Scanner sc = null;

        try {
            sc = new Scanner(f);
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        sc.nextLine();
        for (int i = 0; i < k; i++) {

            if(!(sc.hasNext())) throw new IllegalArgumentException();
            StringTokenizer st = new StringTokenizer(sc.nextLine()," ");

            Punto p = new Punto(st.nextToken(),st.nextToken());
            centroidi[i] = p;

            dataSet.put(p,i);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("KMeans{");
        sb.append("dataSet=").append(dataSet);
        sb.append("\ncentroidi=").append(Arrays.toString(centroidi));
        sb.append('}');
        return sb.toString();
    }

    void run(int maxIte) {
        for (; maxIte > 0; maxIte--) {
            for (Punto p : dataSet.keySet()) {
                int min = Integer.MAX_VALUE;
                Punto P = null;
                int c = 0;
                for (int i = 0; i < centroidi.length; i++) {
                    double distanza = centroidi[i].Distanza(p);

                    if (distanza != 0 && distanza < min) {
                        distanza = min;
                        P = new Punto(centroidi[i].getX(), centroidi[i].getY());
                        c = i;
                    }
                    dataSet.put(p,dataSet.get(p));
                }
            }
        }
    }
}
