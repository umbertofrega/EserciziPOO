package KMeans;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class DataSet {

    void crea(File f,int N, int MIN, int MAX) throws IOException {

        FileWriter fW = null;
        try {
            fW = new FileWriter(f);
        } catch (IOException e) {
            System.out.println("File non trovato");
            throw new FileNotFoundException();
        }

        for (int i = 0; i < N; i++) {
            double X=Math.random()*(MAX-MIN)+MIN, Y=Math.random()*(MAX-MIN)+MIN;
            fW.write("\n");
            fW.write(X+" "+Y);
        }

    }


protected static class Punto {
        private double x;
        private double y;

    public Punto(double x, double y ){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Punto(String x, String y ){
        this.x= Double.parseDouble(x);
        this.y = Double.parseDouble(y);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("<");
        sb.append(x);
        sb.append(",").append(y);
        sb.append('>');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Punto)) return false;
        Punto punto = (Punto) o;
        return Objects.equals(x, punto.x) && Objects.equals(y, punto.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public double Distanza(Punto p) {
        double d = 0;
        double d2 = 0;

        d = (p.x - this.x)*(p.x - this.x);
        d2 = (p.y - this.y)*(p.y - this.y);
        d+=d2;

        return Math.sqrt(d);
    }

    public Punto puntoMedio(Punto P){

        return new Punto(((P.x+this.y)/2),((P.y+this.y)/2));

    }


    }
}

